import java.util.ArrayList;
import java.util.List;
public class Squad{
    private String sName;
    private  String cause;
    private int id;
    private  int size;
private static ArrayList<Squad>instance=new ArrayList<Squad>();

private List<Hero>hHeroes;

    public Squad(String sName,String cause,int size) {
       this.sName=sName;
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
}
