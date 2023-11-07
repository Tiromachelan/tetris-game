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
      JFrame frame = new JFrame("Tetris");
      JPanel tetris_panel = new JPanel();    
      JLabel score_label = new JLabel("<html> Score: 0 <br> High Score: " + highScore + "</html>");     
      Tetris tetris = new Tetris();
      tetris.setPreferredSize(new Dimension(560, 838));            
      tetris_panel.setLayout(new BorderLayout());
      tetris_panel.add(tetris);
      frame.setSize(670, 838);
      frame.setVisible(true);
      frame.add(score_label, BorderLayout.CENTER);
      frame.add(tetris_panel, BorderLayout.LINE_START);
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
      tetris.requestFocusInWindow();

      // Run the game
      while (true) {
         try {
            Thread.sleep(1000 - (tetris.getScore() * 10));
         } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
         }
         if (!tetris.getGameOver()) {
            tetris.move();
            score_label.setText("<html> Score: " + tetris.getScore() + "<br> High Score: " + highScore + "</html>");
            if (tetris.getScore() > highScore) {
               highScore = tetris.getScore();
               PrintWriter out = new PrintWriter("highscore.txt");
               out.print(highScore);
               out.close();
            }
         } else {
            PrintWriter out = new PrintWriter("highscore.txt");
            out.print(highScore);
            out.close();
            tetris.displayGameOverScreen(tetris_panel, score_label, tetris, highScore, frame);
            break;
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

   public void displayGameOverScreen(JPanel tetris_panel, JLabel score_label, Tetris tetris, int highScore, JFrame frame) {
      StringBuilder gameOverSpaces = new StringBuilder();
      StringBuilder scoreSpaces = new StringBuilder();
      StringBuilder highScoreSpaces = new StringBuilder();
      StringBuilder newGameSpaces = new StringBuilder();
      for (int i = 0; i < 98; i++) {
         if (i < 35) {
            gameOverSpaces.append("\u00a0");
         }
         if (i < 98) {
            scoreSpaces.append("\u00a0");
         }
         if (i < 93) {
            highScoreSpaces.append("\u00a0");
         }
         if (i < 79) {
            newGameSpaces.append("\u00a0");
         }
      }

      score_label.setText("<html>" + scoreSpaces + "Score: " + tetris.getScore() + "<br>" + highScoreSpaces.toString() + "High Score: " + highScore + "<br> <H1>" + gameOverSpaces.toString() + "GAME OVER </H1> <br>" + newGameSpaces.toString() + "Press spacebar to play again </br> </html>");
      frame.setComponentZOrder(tetris_panel, 0);
   }

   public void callNewGame() {
      newGame();
   }

   public static void newGame() {
      try {
         String java = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
         String className = Tetris.class.getCanonicalName();
         ProcessBuilder builder = new ProcessBuilder(java, className);
         builder.start();
         System.exit(0);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
