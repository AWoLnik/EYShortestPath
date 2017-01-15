import java.awt.*;
import javax.swing.*;

public class Main extends JFrame
{
  private JTextField display;

  public Main()
  {
    Container c = getContentPane();

    display = new JTextField(20);
    display.setBackground(Color.YELLOW);
    display.setEditable(false);
    c.add(display, BorderLayout.NORTH);

    SchoolPanel board = new SchoolPanel();
    c.add(board, BorderLayout.CENTER);

    display.setText(" Click on two locations in EYHS to see the shortest path between them.");
  }

  public static void main(String[] args)
  {
    Main window = new Main();
    window.setTitle("EYHS Shortest Path");
    window.setBounds(200, 200, 721, 380);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);
  }
}
