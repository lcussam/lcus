package a;

public class CSGameFactory implements GameFactory
{
	public Game produceGame()
	{
		System.out.println("CS工厂生产CS角色");
		return new CSGame();
	}
}