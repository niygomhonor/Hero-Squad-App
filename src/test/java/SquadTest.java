
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {



    @Test
    public void squadInstancesCreated() {
        Squad squadTest= new Squad(" Akia","Tank",4);
        assertEquals(true,squadTest instanceof Squad);
    }

    @Test
    public void getName_squadInstanceWith_Nameand_Cause() {
        Squad squadTest= new Squad(" superMan","Tank",4);
assertEquals("superMan",squadTest.getsName());
    }

    @Test
    public void getSize_Of_Squad() {
        Squad squadTest= new Squad(" Akia","Tank",4);
        assertEquals(4, squadTest.getsSize());
    }


}