package xuliehua;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
public class TestBean extends BaseBean
{
	public String desc;
    @Override
    public String toString()
    {
        return "TestBean{" +
                "desc='" + desc + '\'' +
                ", property1='" + property1 + '\'' +
                ", property2='" + property2 + '\'' +
                '}';
    }
    
}
