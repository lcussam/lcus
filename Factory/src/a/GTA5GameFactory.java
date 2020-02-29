package a;

public class GTA5GameFactory implements GameFactory
{
	public Game produceGame()
	{
		System.out.println("GTA5工厂生产GTA5角色");
		return new GTA5Game();
	}
}