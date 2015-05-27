package axce.zeubway.view;

import java.awt.Color;

import javax.swing.JPanel;

import axce.zeubway.model.Cell;

public class CellView extends JPanel
{
	private Cell cell;
	
	public CellView(Cell cell)
	{
		this.cell = cell;
		if (this.cell.isAlive()) setBackground(Color.WHITE);
		else setBackground(Color.BLACK);
	}

	public void update()
	{
		if (this.cell.isAlive()) setBackground(Color.WHITE);
		else setBackground(Color.BLACK);
	}
}
