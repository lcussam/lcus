package a;

import java.io.IOException;
import org.xml.sax.SAXException;

public class Client
{
	public static void main(String[] args)
	{
		try
		{
			
			GameFactory factory=(GameFactory)XMLUtil.getBean();
			//factory=new GTA5GameFactory();
			Game game=factory.produceGame();
			game.play();
		}catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SAXException |IOException e) {
			e.printStackTrace();
		}
	}
}