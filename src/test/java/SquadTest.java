import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void squadInstancesCreated() {
        Squad squadTest= new Squad(" Akia","Tank",4);
        assertEquals(true,squadTest instanceof Squad);
    }

    @Test
    public void getName_squadInstanceWith_Nameand_Cause() {
        Squad squadTest= new Squad(" Akia","Tank",4);
assertEquals("Akia",squadTest.getsName());
    }

    @Test
    public void getSize_Of_Squad() {
        Squad squadTest= new Squad(" Akia","Tank",4);
        assertEquals(4, squadTest.getsSize());
    }

    @After
    public void tearDown() throws Exception {
    }
}