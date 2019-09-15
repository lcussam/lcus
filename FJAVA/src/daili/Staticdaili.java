package daili;

public class Staticdaili implements HelloWorld
{
   public HelloWorld helloworld;
   public Staticdaili(HelloWorld helloworld)
   {
	   this.helloworld=helloworld;
   }
   public void print()
   {
	   System.out.println("Welcome");
	   helloworld.print();
   }
   public void say()
   {
	   helloworld.say();
   }
}
