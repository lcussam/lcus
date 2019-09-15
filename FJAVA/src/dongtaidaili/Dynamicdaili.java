package dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class Dynamicdaili implements InvocationHandler
{
   private Object object;
   public Object bindRelation(Object object)
   {
	   this.object=object;
	   return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
   }
   public Object invoke(Object proxy,Method method,Object[] args) throws Throwable
   {
	   System.out.println("Welcome");
	   Object result=method.invoke(object, args);
	   return result;
   }
}
