import org.sql2o.Connection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Sighting {
    private String location;
    private String rangerName;
    private int id;
    public int animalId;

 public Sighting(String location,String rangerName,int animalId){
     this.location=location;
     this.rangerName=rangerName;
     this.animalId=animalId;

 }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getId() {
        return id;
    }

    public int getAnimalId() {
        return animalId;
    }
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM sightings WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }
    public static List<Sighting> all() {
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }
    public static Sighting find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM persons where id=:id";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }
    }
    public List<Object> getAnimals() {
        List<Object> allAnimals = new ArrayList<Object>();

        try(Connection con = DB.sql2o.open()) {
            String sqlAnimal = "SELECT * FROM monsters WHERE personId=:id";
            List<Animal> animals = con.createQuery(sqlAnimal)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
            allAnimals.addAll(animals);

            String sqlEndangeredAnimal = "SELECT * FROM monsters WHERE personId=:id AND type='endangered';";
            List<EndangeredAnimal> endangeredAnimals = con.createQuery(sqlEndangeredAnimal)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
            allAnimals.addAll(endangeredAnimals);
        }

        return allAnimals;
    }

}
