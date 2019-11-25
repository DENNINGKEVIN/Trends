import java.util.Objects;

public class EndangeredAnimal  {
    public int id;
    public String name;
    public String health;
    public int age;

    public EndangeredAnimal(String name,String health,int age){
        this.name=name;
        this.health=health;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public String getHealth() {
        return health;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndangeredAnimal that = (EndangeredAnimal) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(health, that.health);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, health, age);
    }
}
