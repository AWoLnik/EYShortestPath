import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class SchoolPanel extends JPanel
{
  private final int ROWS = 9, COLS = 18;   // board dimensions
  private final int CELLSIZE = 40;

  // Constructor
  public SchoolPanel()
  {
    setPreferredSize(new Dimension(COLS * CELLSIZE, ROWS * CELLSIZE));
    setBackground(Color.LIGHT_GRAY);
  }

  // Returns the number of rows in the board
  public int numRows()
  {
    return ROWS;
  }

  // Returns the number of columns in the board
  public int numCols()
  {
    return COLS;
  }

  // Returns the location that corresponds to the x,y-coordinates
  // of the mouse click on the board
  public Location getPos(int x, int y)
  {
    return new Location(y / CELLSIZE, x / CELLSIZE);
  }

  private School school;

  // Repaints the board after the move at row, col
  public void update(School school)
  {
    this.school = school;
    repaint();
  }

  // Displays the board after a repaint request
  // (redefines the method of the base class)
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    if (school == null)
      return;

    for (int r = 0; r < ROWS; r++)
    {
      for (int c = 0; c < COLS; c++)
      {
        Color color;

        if (school.isEmpty(r, c))
          color = Color.BLACK;
        else if (school.charAt(r, c) == 's')
        	color = Color.GRAY;
        else if (school.charAt(r, c) == 'o')
        	color = Color.YELLOW;
        else
          color = Color.WHITE;
        g.setColor(color);
        int x = c * CELLSIZE;
        int y = r * CELLSIZE;
        g.fillRect(x, y, CELLSIZE, CELLSIZE);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, CELLSIZE, CELLSIZE);
        g.drawRect(x+1, y+1, CELLSIZE-2, CELLSIZE-2);
      }
    }
  }
}