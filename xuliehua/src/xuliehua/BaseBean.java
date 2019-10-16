package xuliehua;
import java.io.Serializable; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
public class BaseBean implements Serializable
{
	   public static final int serialVersionUID = 1;
	   public String property1;
	   public String property2;
}
