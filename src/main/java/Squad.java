import java.util.ArrayList;
import java.util.List;

public class Squad{
    private String sName;
    private  String sCause;
    private int sId;
private static ArrayList<Squad>instance=new ArrayList<Squad>();
private List<Hero>hHeroes;
    public Squad(String name, String cause) {
       sName=name;
      sCause=cause;
      instance.add(this);
      hHeroes=new ArrayList<Hero>();
    }

    public String getsName() {

        return sName;
    }
public List<Hero> gethHeroes(){
        return hHeroes;
}
    public String getsCause() {
        return sCause;
    }

}
