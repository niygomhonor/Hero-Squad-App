import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Squad{
    private String sName;
    private  String cause;
    private int id;
    private  int size;
private static ArrayList<Squad>instance=new ArrayList<Squad>();

private List<Hero>hHeroes;

    public Squad(String sname, String cause,int size) {
       this.sName=sname;
      this.cause=cause;
      this.size=size;
      instance.add(this);
      hHeroes=new ArrayList<Hero>();
        this.id=instance.size();
    }

    public String getsName() {

        return sName;
    }

    public int getsSize() {
        return size;
    }

    public List<Hero> gethHeroes(){

        return hHeroes;
}
    public String getsCause() {

        return cause;
    }
public static List<Squad>all(){

        return instance;
}

    public void setId(int id) {
        this.id = id;
    }

    public static Squad findSquadById(int id) {
        return instance.get(id-1);
    }
    public int getId() {

        return id;
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
