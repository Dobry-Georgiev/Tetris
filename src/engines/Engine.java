package engines;

import Builders.FrameBuilder;
import Builders.MainMenu;

public class Engine 
{
	MainMenu mainMenu;
	public Engine()
	{
		FrameBuilder.buildFrame();
		mainMenu = new MainMenu();
	}
}
