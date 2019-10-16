package xuliehua2;
import java.io.Serializable; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
public class TestBean2 extends BaseBean2  implements Serializable
{
	 public String desc;
	    public static final int serialVersionUID = 1;
	    public TestBean2(String id) {
	        super(id);
	    }
	 
	    @Override
	    public String toString() {
	        return "TestBean{" +
	                "desc='" + desc + '\'' +
	                ", property1='" + property1 + '\'' +
	                ", property2='" + property2 + '\'' +
	                '}';
	    }
}
