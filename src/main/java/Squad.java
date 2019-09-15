import java.util.ArrayList;
import java.util.List;

public class Squad{
    private String sName;
    private  String sCause;
    private int sId;
    private  int sSize;
private static ArrayList<Squad>instance=new ArrayList<Squad>();
private List<Hero>hHeroes;

    public Squad(String name, String cause,int size) {
       sName=name;
      sCause=cause;
      sSize=size;
      instance.add(this);
      hHeroes=new ArrayList<Hero>();
    }

    public String getsName() {

        return sName;
    }

    public int getsSize() {
        return sSize;
    }



    public List<Hero> gethHeroes(){

        return hHeroes;
}
    public String getsCause() {

        return sCause;
    }
public static List<Squad>all(){

        return instance;
}
    public static Squad find(int id) {
        return instance.get(id - 1);
    }
    public int getId() {
        return sId;
    }
    public void addHero(Hero hero) {
        hHeroes.add(hero);
    }
    public static boolean heroAlreadyExists(Hero newHero) {
        boolean exists = false;
        for (Squad squad : instance) {
            for (Hero hero : squad.gethHeroes()) {
                if (hero.getName().equals(newHero.getName())) {
                    exists = true;
                }
            }
        }
        return exists;
    }
}
