import java.util.ArrayList;

public class Hero {
    private String hName;
    private String hAge;
    private String hPower;
    private String hWeakness;
    private int hId;
private static ArrayList<Hero> insta=new ArrayList<Hero>();
    public Hero(String name, String age, String power, String weakness) {
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

    public String getAge() {
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
