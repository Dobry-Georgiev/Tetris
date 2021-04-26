package tetris.builder;

public class Engine 
{
	MainMenu mainMenu;
	public Engine()
	{
		FrameBuilder.buildFrame();
		mainMenu = new MainMenu();
	}
}
