import java.awt.*;

public class Grid {
   Tetris tetris;
   
   public Grid (Tetris tetris) {
      this.tetris = tetris;
   }

   public void paint(Graphics2D g) {
      // Main grid
      g.setColor(Color.BLACK);
      for (int i = 0; i < 11; i++) {// vertical lines
         g.fillRect(i * 40, 0, 2, 815);
      }
      for (int i = 0; i < 21; i++) {// horizontal lines
         g.fillRect(0, i * 40, 400, 1);
      }
      
      // Shape queue
      for (int i = 0; i < 5; i++) {// vertical lines
         g.fillRect(i * 20 + 430, 0 + 20, 2, 400);
      }
      g.fillRect(510, 0 + 20, 3, 403);
      g.fillRect(430, 0 + 20, 3, 400);
      for (int i = 0; i < 21; i++) {// horizontal lines
         g.fillRect(430, i * 20 + 20, 80, 1);
      }
      for (int i = 0; i < 6; i++) {// horizontal lines
         g.fillRect(430, i * 80 + 20, 80, 3);
      }

      // Swap
      g.fillRect(510, 0 + 20 + 440, 3, 83);// vertical
      g.fillRect(430, 0 + 20 + 440, 3, 80);// vertical
      g.fillRect(430, 460, 80, 3);// horizontal
      g.fillRect(430, 480, 80, 1);// horizontal
      g.fillRect(430, 500, 80, 1);// horizontal
      g.fillRect(430, 520, 80, 1);// horizontal
      g.fillRect(430, 540, 80, 3);// horizontal
      for (int i = 0; i < 5; i++) {// vertical lines
         g.fillRect(i * 20 + 430, 460, 2, 80);
      }
   }
}
