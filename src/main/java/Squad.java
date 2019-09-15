import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Squad{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return sSize == squad.sSize &&
                id == squad.id &&
                Objects.equals(sName, squad.sName) &&
                Objects.equals(sCause, squad.sCause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sName,sCause,sSize, id);
    }
    private String sName;
    private  String sCause;
    private int id;
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

    public void setId(int id) {
        this.id = id;
    }

    public static Squad find(int id) {
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
