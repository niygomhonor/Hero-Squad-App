import java.util.ArrayList;

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

    public int getAge() {
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

}
