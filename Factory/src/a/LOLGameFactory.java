package a;

public class LOLGameFactory implements GameFactory
{
	public Game produceGame()
	{
		System.out.println("LOL工厂生产LOL角色");
		return new LOLGame();
	}
}