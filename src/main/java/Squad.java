import java.util.ArrayList;

public class Squad{
    private String sName;
    private  String sCause;
    private int sId;
private static ArrayList<Squad>instances=new ArrayList<Squad>();
    public Squad(String name, String cause) {
       sName=name;
      sCause=cause;
    }

    public String getsName() {
        return sName;
    }

    public String getsCause() {
        return sCause;
    }

}
