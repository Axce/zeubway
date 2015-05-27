package axce.zeubway.model;


public class World
{
	public final static boolean[] BIRTH_RULES = 
		{false, false, false, true, false, false, false, false, false};
	
	public final static boolean[] SURVIVE_RULES = 
		{false, false, true, true, false, false, false, false, false};
	
	private final int xSize;
	private final int ySize;
	private Cell[][] cellArray;
	private int iteration;
	
	public World(int[][] template)
	{
		this.iteration = 0;
		this.xSize = template[0].length;
		this.ySize = template.length;
		
		this.cellArray = new Cell[this.ySize][this.xSize];
		
		for (int y = 0 ; y < ySize ; y++)
		{
			for (int x = 0 ; x < xSize ; x++)
			{
				this.cellArray[y][x]= new Cell(x, y, template[y][x] == 1);
			}
		}
	}

	public void iterate()
	{
		for (int y = 0 ; y < ySize ; y++)
		{
			for (int x = 0 ; x < xSize ; x++)
			{
				if (this.cellArray[y][x].isAlive())
					this.cellArray[y][x].setDestiny(SURVIVE_RULES[this.crowdAround(x, y)]);
				else 
					this.cellArray[y][x].setDestiny(BIRTH_RULES[this.crowdAround(x, y)]);
			}
		}
		
		for (int y = 0 ; y < ySize ; y++)
		{
			for (int x = 0 ; x < xSize ; x++)
			{
				this.cellArray[y][x].update();
			}
		}

		iteration++;
	}
	
	public int crowdAround(int x, int y)
	{
		return 
				(cellArray[Math.floorMod((y - 1) , ySize)][Math.floorMod((x - 1) , xSize)].isAlive() ? 1 : 0) +
				(cellArray[Math.floorMod((y - 1) , ySize)][Math.floorMod((x    ) , xSize)].isAlive() ? 1 : 0) +
				(cellArray[Math.floorMod((y - 1) , ySize)][Math.floorMod((x + 1) , xSize)].isAlive() ? 1 : 0) +
				(cellArray[Math.floorMod((y    ) , ySize)][Math.floorMod((x - 1) , xSize)].isAlive() ? 1 : 0) +
				(cellArray[Math.floorMod((y    ) , ySize)][Math.floorMod((x + 1) , xSize)].isAlive() ? 1 : 0) +
				(cellArray[Math.floorMod((y + 1) , ySize)][Math.floorMod((x - 1) , xSize)].isAlive() ? 1 : 0) +
				(cellArray[Math.floorMod((y + 1) , ySize)][Math.floorMod((x    ) , xSize)].isAlive() ? 1 : 0) +
				(cellArray[Math.floorMod((y + 1) , ySize)][Math.floorMod((x + 1) , xSize)].isAlive() ? 1 : 0);
	}
	
	public int getIteration()
	{
		return iteration;
	}


	public int getXSize()
	{
		return xSize;
	}

	public int getYSize()
	{
		return ySize;
	}
	
	public Cell getCell(int x, int y)
	{
		return cellArray[y][x];
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("\n" + "iteration " + this.iteration + "\n");
		for (int y = 0 ; y < ySize ; y++)
		{
			for (int x = 0 ; x < xSize ; x++)
			{
				str.append(cellArray[y][x] + " ");
			}
			str.append("\n");
		}
		return str.toString();
	}
}
