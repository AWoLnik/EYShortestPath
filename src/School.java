public class School extends CharMatrix
{
  private SchoolPanel school;

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
   * Returns true if the location on the school is a win
   * for the player whose turn is to move
   */
  public boolean isWon()
  {
    return isEmpty(0, 0);
  }

  /*
   * Adjusts and repaints the school after the move at row, col
   */
  public void makeSelection(int row, int col)
  {
    setCharAt(row, col, 'o');
    school.setDisplayCount(0);
    school.update(this);
  }
}
