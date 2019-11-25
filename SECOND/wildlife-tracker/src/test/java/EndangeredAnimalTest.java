import org.junit.*;
import static org.junit.Assert.*;

public class EndangeredAnimalTest {
    @Test
    public void EndangeredAnimals_instanciatesCorrectly_true(){
        EndangeredAnimal testEndangeredAnimal=new EndangeredAnimal("Tiger","ill",2);
        assertEquals(true,testEndangeredAnimal instanceof EndangeredAnimal);
    }
    @Test
    public void EndangeredAnimals_instanciatesWithName_true(){
        EndangeredAnimal testEndangeredAnimal=new EndangeredAnimal("Tiger","ill",2);
        assertEquals("Tiger",testEndangeredAnimal.getName());
    }
    @Test
    public void EndangeredAnimals_instanciatesWithHealth_true(){
        EndangeredAnimal testEndangeredAnimal=new EndangeredAnimal("Tiger","ill",2);
        assertEquals("ill",testEndangeredAnimal.getHealth());
    }
    @Test
    public void EndangeredAnimals_instanciatesWithAge_true(){
        EndangeredAnimal testEndangeredAnimal=new EndangeredAnimal("Tiger","ill",2);
        assertEquals(2,testEndangeredAnimal.getAge());
    }
    @Test
    public void EndangeredAnimals_returnIfnameIsSame_true(){
        EndangeredAnimal testEndangeredAnimal=new EndangeredAnimal("Tiger","ill",2);
        EndangeredAnimal testEndangeredAnimal1=new EndangeredAnimal("Tiger","ill",2);
        assertTrue(testEndangeredAnimal.equals(testEndangeredAnimal1));
    }


}
