package xuliehua;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.io.Serializable;
public class Test
{
	public void serialization(View view) {
        try {
 
            TestBean testBean = new TestBean();
            testBean.property1 = "属性22882288";
            testBean.property2 = "属性6666";
            testBean.desc = "我是testbean";
 
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
            TestBean testBean = (TestBean) objectInputStream.readObject();
            Log.i(TAG,"deserialization"+testBean.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
