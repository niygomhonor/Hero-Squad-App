import java.util.*;

public class Hero {
    private String hName;
    private int hAge;
    private String hPower;
    private String hWeakness;
    private int hId;
private static ArrayList<Hero> insta=new ArrayList<Hero>();

    public Hero(String name, int age, String power, String weakness) {
        hName = name;
        hAge = age;
        hPower = power;
        hWeakness = weakness;
        insta.add(this);
        hId=insta.size();
    }

    public String getName() {

        return hName;
    }

    public int getAge()
    {
        return hAge;
    }

    public String getPower() {
        return hPower;
    }

    public String getWeakness() {
        return hWeakness;
    }

    public int getId() {

        return hId;
    }

    public static List<Hero> all() {
        return insta;
    }
    public static void clear() {
      insta.clear();
    }
    public static Hero find(int id) {
        return insta.get(id - 1);
    }
}
