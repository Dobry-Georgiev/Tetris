package engines;

import builders.FrameBuilder;
import builders.ProgramStarter;
import menus.MainMenu;

public class Engine 
{
	MainMenu mainMenu;
	public Engine()
	{
		FrameBuilder.buildFrame();
		ProgramStarter.StartProgram();
	}
}
