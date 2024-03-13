import java.util.Objects;
public class RecIntegral {
    public String step ;
    public String b;
    public String a;
    public String res;
    public RecIntegral (String step, String b, String a, String res){
        this.step = step;
        this.b = b;
        this.a = a;
        this.res = res;
    }
    public void getComp(String step, String b, String a, String res){
        if(Objects.equals(step, this.step) && Objects.equals(b, this.b) && Objects.equals(a, this.a)){
            this.res = res;
        }
    }
}
