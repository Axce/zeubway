package axce.zeubway.model;

public class Cell
{
	private final int x;
	private final int y;
	private boolean isAlive;
	private boolean willLive;
	
	public boolean isAlive()
	{
		return isAlive;
	}

	public Cell(int x, int y, boolean isAlive)
	{
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
	}
	
	@Override
	public String toString()
	{
		if (this.isAlive) return "O";
		return ".";
	}

	public void setDestiny(boolean destiny)
	{
		this.willLive= destiny;
	}
	
	public void update()
	{
		this.isAlive= willLive;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	
	
}
