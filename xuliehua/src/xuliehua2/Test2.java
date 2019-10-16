package xuliehua2;
import java.io.Serializable; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
public class Test2
{
	public void serialization(View view) {
        try {
 
            TestBean2 testBean = new TestBean2("");
            testBean.property1 = "属性88999988";
            testBean.property2 = "属性88999988";
            testBean.desc = "我是testbean88999988";
 
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/sdcard/aaatest.txt"));
            objectOutputStream.writeObject(testBean);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public void deserialization(View view) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("/sdcard/aaatest.txt"));
            TestBean2 testBean = (TestBean2) objectInputStream.readObject();
            Log.i(TAG,"deserialization"+testBean.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
