package axce.zeubway.view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import axce.zeubway.model.World;


public class WorldWindow extends JFrame
{
	
	private WorldView worldView;
	
	public WorldWindow(World world)
	{
	    this.setTitle("Zeubway");
	    this.setSize(world.getXSize()*16,world.getYSize()*16 + 64);
	    this.setResizable(false);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    worldView = new WorldView(world);
	    this.add(worldView);
	    this.setVisible(true);
	}
	
	public void update()
	{
		worldView.update();
	}

}
