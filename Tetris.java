import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Tetris extends JPanel {
   public static void main(String[] args) throws IOException {
      int highScore = 0;
      Scanner reader = new Scanner(new File("highscore.txt"));
      highScore = reader.nextInt();
      PrintWriter out = new PrintWriter("highscore.txt");
      JFrame frame = new JFrame("Tetris");
      JPanel tetris_panel = new JPanel();    
      JLabel score_label = new JLabel("<html> Score: 0 <br> High Score: " + highScore + "</html>");     
      Tetris tetris = new Tetris();
      tetris.setPreferredSize(new Dimension(560, 838));            
      tetris_panel.setLayout(new BorderLayout());
      tetris_panel.add(tetris);
      frame.setSize(670, 838);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      frame.add(score_label, BorderLayout.CENTER);
      frame.add(tetris_panel, BorderLayout.LINE_START);

      // Run the game
      while (true) {
         try {
            Thread.sleep(1000 - (tetris.getScore() * 10));
         } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
         }
         tetris.move();
         score_label.setText("<html> Score: " + tetris.getScore() + "<br> High Score: " + highScore + "</html>");
         if (tetris.getScore() > highScore) {
            highScore = tetris.getScore();
         }
         if (tetris.getGameOver()) {
            out.print(highScore);
            out.close();
            System.exit(0);
         }
         tetris.repaint();
      }
   }
   Shape shape = new Shape(this);
   Grid grid = new Grid(this);
      
   public Tetris() {
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				shape.keyPressed(e);
			}
		});
		setFocusable(true);
	}
   
   public void move() {
      shape.move();
   }

   public int getScore() {
      return shape.getScore();
   }

   public boolean getGameOver() {
      return shape.getGameStatus();
   }
   
   public void paint(Graphics g) {
      Graphics2D g2d = (Graphics2D) g;
      if (shape.shape == 0) {
         for (int i = 0; i < shape.shapes.length; i++) {
            shape.shapes[i] = (int)(Math.random() * 7) + 1;
         }
      }
      super.paint(g);
      shape.paint(g2d);
      grid.paint(g2d);
   }
}
