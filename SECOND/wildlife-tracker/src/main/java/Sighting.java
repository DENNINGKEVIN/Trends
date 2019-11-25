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
}
