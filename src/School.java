import java.util.ArrayList;

public class School extends CharMatrix
{
  private SchoolPanel school;
  private ArrayList<Location> selected;
  private Location goal;

  public School(SchoolPanel school)
  {
    super(school.numRows(), school.numCols(), 'x');
    this.school = school;
    
    fillRect(0, 0, 3, 1, ' ');
    fillRect(5, 0, 8, 1, ' ');
    fillRect(0, 3, 0, 8, ' ');
    fillRect(3, 3, 5, 8, ' ');
    fillRect(8, 3, 8, 8, ' ');
    fillRect(2, 4, 2, 7, ' ');
    fillRect(6, 4, 6, 7, ' ');
    fillRect(0, 9, 8, 9, ' ');
    fillRect(0, 10, 3, 10, ' ');
    fillRect(5, 10, 8, 10, ' ');
    fillRect(0, 12, 0, 17, ' ');
    fillRect(3, 12, 5, 17, ' ');
    fillRect(8, 12, 8, 17, ' ');
    fillRect(2, 13, 2, 16, ' ');
    fillRect(6, 13, 6, 16, ' ');
    
    setCharAt(2, 3, 's');
    setCharAt(6, 3, 's');
    setCharAt(2, 8, 's');
    setCharAt(6, 8, 's');
    setCharAt(2, 12, 's');
    setCharAt(6, 12, 's');
    setCharAt(2, 17, 's');
    setCharAt(6, 17, 's');
    
    school.update(this);
    
    selected = new ArrayList<Location>();
  }

  /*
   * Returns true if row, col is out of bounds or the character
   * at row, col is a space, false otherwise.
   */
  public boolean isEmpty(int row, int col)
  {
    return row < 0 || row >= numRows() || col < 0 || col >= numCols() ||
           super.isEmpty(row, col);
  }

  /*
   * Adjusts and repaints the school after the move at row, col
   */
  public void makeSelection(int row, int col)
  {
	Location l = new Location(row, col);
	
	if (charAt(row, col) == 'o') {
		setCharAt(row, col, 'x');
		if (selected.contains(l))
			selected.remove(l);
	}
	else if (selected.size() < 2){
		setCharAt(row, col, 'o');
		selected.add(l);
	}
    school.update(this);
    
    if (selected.size() == 2) {
    	goal = selected.get(0);
    	ArrayList<Location> a = new ArrayList<Location>();
    	ArrayList<Location> shortestPath = computeShortestPath(l, l, a);
    	for (Location p: shortestPath)
    		setCharAt(p.getRow(), p.getCol(), 'p');
    	school.update(this);
    }
  }
  
  // Location l is the location to analyze, Location p is the previous location
  // (which is to be avoided), and Location[] a is the path being built out
  private ArrayList<Location> computeShortestPath(Location l, Location p, ArrayList<Location> a)
  {
	  if (goal == l)
		  return a;
	  else {
		  ArrayList<ArrayList<Location>> paths = new ArrayList<ArrayList<Location>>();
		  
		  // check North
		  Location n = new Location(l.getRow()-1, l.getCol());
		  if (n != p && !isEmpty(n.getRow(), n.getCol()))
				  paths.add(computeShortestPath(n, l, a));
		  
		  // check East
		  Location e = new Location(l.getRow(), l.getCol()+1);
		  if (e != p && !isEmpty(e.getRow(), e.getCol()))
				  paths.add(computeShortestPath(e, l, a));
		  
		  // check South
		  Location s = new Location(l.getRow()+1, l.getCol());
		  if (s != p && !isEmpty(s.getRow(), s.getCol()))
				  paths.add(computeShortestPath(s, l, a));
		  
		  // check West
		  Location w = new Location(l.getRow(), l.getCol()-1);
		  if (w != p && !isEmpty(w.getRow(), w.getCol()))
				  paths.add(computeShortestPath(w, l, a));
		  
		  if (n == p && e == p && s == p && w == p)
			  return a;
		  
		  int shortestLength = paths.get(0).size();
		  int shortestPath = 0;
		  
		  for (int i = 0; i < paths.size(); i++)
			  if (paths.get(i).size() < shortestLength) {
				  shortestLength = paths.get(i).size();
				  shortestPath = i;
			  }
		  
		  paths.get(shortestPath).add(l);
		  return paths.get(shortestPath);
	  }
  }
}
