import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Hero_instantiating_Done_Correctly() {
        Hero amHero = new Hero("Honorine", 20, "Ever present", "Calm");
    }

    @Test
    public void getName_forHeroesName_String() {
        Hero myHero = new Hero("Vick", 65, "madem", "madem");
        String expected = "Vick";
        assertEquals(expected, myHero.getName());
    }

    @Test
    public void getAge_forHeroesName_String() {
        Hero myHero = new Hero("Vick", 65, "madem", "madem");
        int expected = 65;
        assertEquals(expected, myHero.getAge());
    }

    @Test
    public void getWeakness_forHeroesName_String() {
        Hero myHero = new Hero("Vick", 65, "madem", "madem");
        String expected = "madem";
        assertEquals(expected, myHero.getWeakness());
    }

    @Test
    public void getPower_forHeroesName_String() {
        Hero myHero = new Hero("Vick", 65, "madem", "madem");
        String expected = "madem";
        assertEquals(expected, myHero.getPower());
    }
}