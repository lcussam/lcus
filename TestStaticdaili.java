package daili;

public class TestStaticdaili
{
  public static void main(String[] args)
  {
	  HelloWorld helloworld=new HelloWorldImpl();
	  Staticdaili staticdaili=new Staticdaili(helloworld);
	  staticdaili.print();
	  staticdaili.say();
  }
}
