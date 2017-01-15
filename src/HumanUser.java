/*
* Implements a human player in a schoolPanel school
 */

import java.awt.event.*;

public class HumanUser implements MouseListener
{
  private School school;
  private SchoolPanel schoolPanel;

  public HumanUser(Main program, School school, SchoolPanel schoolPanel)
  {
    this.school = school;
    this.schoolPanel = schoolPanel;
    schoolPanel.addMouseListener(this);
  }

  /*
   * Called automatically when the mouse button is released
   */
  public void mouseReleased(MouseEvent e)
  {
    // schoolPanel "knows" how to translate raw pixel coordinates x, y
    //   into row, col on the schoolPanel:

    Location pos = schoolPanel.getPos(e.getX(), e.getY());
    int row = pos.getRow();
    int col = pos.getCol();
    
    //if (!school.isEmpty(row, col))
      school.makeSelection(row, col);
  }

  // Not used but required by the MouseListener interface spec:
  public void mouseClicked(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
}
