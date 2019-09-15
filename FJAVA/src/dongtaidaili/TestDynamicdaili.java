package dongtaidaili;

public class TestDynamicdaili
{
   public static void main(String[] args)
   {
	   HelloWorld helloWorld=new HelloWorldImpl(); 
	   Dynamicdaili dd=new Dynamicdaili();
	   HelloWorld helloWorld1=(HelloWorld)dd.bindRelation(helloWorld);
	   helloWorld1.print();
	   helloWorld1.say();
	   HelloWorld helloWorld2=new HelloWorldImpl();
	   helloWorld2.print();
	   helloWorld2.say();
   }
}
