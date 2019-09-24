
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {



    @Test
    public void squadInstancesCreated() {
        Squad squadTest= new Squad(" Akim","Tank",4);
        assertEquals(true,squadTest instanceof Squad);
    }

    @Test
    public void getName_squadInstanceWith_Name_and_Cause() {
        Squad squadTest= new Squad(" Akim","Tank",4);
        String expected="Akim";
//assertEquals("Akim",squadTest.getsName());
    }

    @Test
    public void getSize_Of_Squad() {
        Squad squadTest= new Squad(" Akim","Tank",4);
        int expected=4;
        assertEquals(4, squadTest.getsSize());
    }

    @Test
    public void getCauseOf_Squad() {
        Squad squadTest= new Squad(" Akim","Tank",4);
        String expected="Tank";
        assertEquals("Tank", squadTest.getsCause());
    }

}