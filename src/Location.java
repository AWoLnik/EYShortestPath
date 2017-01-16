public class Location
{
  private int row, col;

  public Location(int r, int c)
  {
    row = r;
    col = c;
  }

  public int getRow()
  {
    return row;
  }

  public int getCol()
  {
    return col;
  }
  
  @Override
  public boolean equals(Object x) {
	  Location l = (Location) x;

	  if (l.getRow() == row && l.getCol() == col)
		  return true;
	  else
		  return false;
  }
}
