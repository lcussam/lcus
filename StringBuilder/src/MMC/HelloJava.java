package MMC;

public class HelloJava
{
	public static void main(String[] args)
	{
        String str = "a";
        long starTime = System.currentTimeMillis();
        for(int i = 0; i<10000;i++){
            str = str + i;
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - starTime;
        System.out.println("String time is " + time);
        System.out.println(str);
        StringBuilder builder = new StringBuilder("b");
        starTime = System.currentTimeMillis();
        for(int j = 0; j<10000;j++){
            builder = builder.append(j);
        }
        endTime = System.currentTimeMillis();
        time = endTime - starTime;
        System.out.println("StringBuilder time is " + time);
        System.out.println(builder);
        

    }
}
