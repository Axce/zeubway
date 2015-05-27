package axce.zeubway.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import axce.zeubway.model.Cell;
import axce.zeubway.model.World;

public class WorldView extends JPanel
{
	private World world;

	private CellView[][] cellViewArray;
	
	public WorldView(World world)
	{
		this.world = world;
		setLayout(new GridLayout(world.getYSize(), world.getXSize()));

		
		
		cellViewArray = new CellView[world.getYSize()][world.getXSize()];
		

		
		for (int y = 0 ; y < world.getYSize() ; y++)
		{
			for (int x = 0 ; x < world.getXSize() ; x++)
			{
				cellViewArray[y][x] = new CellView(world.getCell(x, y));
				this.add(cellViewArray[y][x]);
			}
		}
	}

	public void update()
	{
		for (int y = 0 ; y < world.getYSize() ; y++)
		{
			for (int x = 0 ; x < world.getXSize() ; x++)
			{
				cellViewArray[y][x].update();
			}
		}
	}
}
