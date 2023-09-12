import java.awt.*;
import java.awt.event.*;

public class Shape {
   Tetris tetris;
   int x = 160;
   int y = 0;
   int outlineY = 0;
   int shape = 0;
   int rotation = 0;
   int hold = 0;
   int score = 0;
   int time = 1000;
   boolean gameOver = false;
   int[][] board = new int[21][10];
   int[] shapes = new int[5];
   Color lightYellow = new Color(255, 255, 153);
   Color lightCyan = new Color(180, 255, 255);
   Color lightMagenta = new Color(255, 204, 255);
   Color lightOrange = new Color(255, 229, 204);
   Color lightBlue = new Color(204, 204, 255);
   Color lightGreen = new Color(204, 255, 229);
   Color lightRed = new Color(255, 204, 204);
   
   public Shape (Tetris tetris) {
      this.tetris = tetris;
      for (int i = 0; i < 20; i++) {
         for (int j = 0; j < 10; j++) {
            board[i][j] = 0;
         }
      }
      for (int i = 0; i < 10; i++) {
         board[20][i] = 9;
      }
   }
   
   public void paint(Graphics2D g) {
      if (shape == 1) {
         if (outlineY > y) {
            g.setColor(lightYellow);
            g.fillRect(x, outlineY, 80, 80);
         }
         g.setColor(Color.YELLOW);
         g.fillRect(x, y, 80, 80);
      }
      if (shape == 2) {
         if (rotation == 0 || rotation == 2) {
            if (outlineY > y) {
               g.setColor(lightCyan);
               g.fillRect(x, outlineY, 40, 160);
            }
            g.setColor(Color.CYAN);
            g.fillRect(x, y, 40, 160);
         }
         if (rotation == 1 || rotation == 3) {
            if (outlineY > y) {
               g.setColor(lightCyan);
               g.fillRect(x, outlineY, 160, 40);
            }
            g.setColor(Color.CYAN);
            g.fillRect(x, y, 160, 40);
         }
      }
      if (shape == 3) {
         if (rotation == 0) {
            if (outlineY > y) {
               g.setColor(lightMagenta);
               g.fillRect(x, outlineY, 120, 40);
               g.fillRect(x + 40, outlineY + 40, 40, 40);
            }
            g.setColor(Color.MAGENTA);
            g.fillRect(x, y, 120, 40);
            g.fillRect(x + 40, y + 40, 40, 40);
         }
         if (rotation == 1) {
            if (outlineY > y) {
               g.setColor(lightMagenta);
               g.fillRect(x, outlineY, 40, 120);
               g.fillRect(x - 40, outlineY + 40, 40, 40);
            }
            g.setColor(Color.MAGENTA);
            g.fillRect(x, y, 40, 120);
            g.fillRect(x - 40, y + 40, 40, 40);
         }
         if (rotation == 2) {
            if (outlineY > y) {
               g.setColor(lightMagenta);
               g.fillRect(x, outlineY, 120, 40);
               g.fillRect(x + 40, outlineY - 40, 40, 40);
            }
            g.setColor(Color.MAGENTA);
            g.fillRect(x, y, 120, 40);
            g.fillRect(x + 40, y - 40, 40, 40);
         }
         if (rotation == 3) {
            if (outlineY > y) {
               g.setColor(lightMagenta);
               g.fillRect(x, outlineY, 40, 120);
               g.fillRect(x + 40, outlineY + 40, 40, 40);
            }
            g.setColor(Color.MAGENTA);
            g.fillRect(x, y, 40, 120);
            g.fillRect(x + 40, y + 40, 40, 40);
         }
      }
      if (shape == 4) {
         if (rotation == 0) {
            if (outlineY > y) {
               g.setColor(lightOrange);
               g.fillRect(x, outlineY, 40, 120);
               g.fillRect(x - 40, outlineY, 40, 40);
            }
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, 40, 120);
            g.fillRect(x - 40, y, 40, 40);
         }
         if (rotation == 1) {
            if (outlineY > y) {
               g.setColor(lightOrange);
               g.fillRect(x, outlineY, 120, 40);
               g.fillRect(x + 80, outlineY - 40, 40, 40);
            }
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, 120, 40);
            g.fillRect(x + 80, y - 40, 40, 40);
         }
         if (rotation == 2) {
            if (outlineY > y) {
               g.setColor(lightOrange);
               g.fillRect(x, outlineY, 40, 120);
               g.fillRect(x + 40, outlineY + 80, 40, 40);
            }
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, 40, 120);
            g.fillRect(x + 40, y + 80, 40, 40);
         }
         if (rotation == 3) {
            if (outlineY > y) {
               g.setColor(lightOrange);
               g.fillRect(x, outlineY, 120, 40);
               g.fillRect(x, outlineY + 40, 40, 40);
            }
            g.setColor(Color.ORANGE);
            g.fillRect(x, y, 120, 40);
            g.fillRect(x, y + 40, 40, 40);
         }
      }
      if (shape == 5) {
         if (rotation == 0) {
            if (outlineY > y) {
               g.setColor(lightBlue);
               g.fillRect(x, outlineY, 40, 120);
               g.fillRect(x + 40, outlineY, 40, 40);
            }
            g.setColor(Color.BLUE);
            g.fillRect(x, y, 40, 120);
            g.fillRect(x + 40, y, 40, 40);
         }
         if (rotation == 1) {
            if (outlineY > y) {
               g.setColor(lightBlue);
               g.fillRect(x, outlineY, 120, 40);
               g.fillRect(x + 80, outlineY + 40, 40, 40);
            }
            g.setColor(Color.BLUE);
            g.fillRect(x, y, 120, 40);
            g.fillRect(x + 80, y + 40, 40, 40);
         }
         if (rotation == 2) {
            if (outlineY > y) {
               g.setColor(lightBlue);
               g.fillRect(x, outlineY, 40, 120);
               g.fillRect(x - 40, outlineY + 80, 40, 40);
            }
            g.setColor(Color.BLUE);
            g.fillRect(x, y, 40, 120);
            g.fillRect(x - 40, y + 80, 40, 40);
         }
         if (rotation == 3) {
            if (outlineY > y) {
               g.setColor(lightBlue);
               g.fillRect(x, outlineY, 120, 40);
               g.fillRect(x, outlineY - 40, 40, 40);
            }
            g.setColor(Color.BLUE);
            g.fillRect(x, y, 120, 40);
            g.fillRect(x, y - 40, 40, 40);
         }
      }
      if (shape == 6) {
         if (rotation == 0 || rotation == 2) {
            if (outlineY > y) {
               g.setColor(lightGreen);
               g.fillRect(x, outlineY, 80, 40);
               g.fillRect(x - 40, outlineY + 40, 80, 40);
            }
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 80, 40);
            g.fillRect(x - 40, y + 40, 80, 40);
         }
         if (rotation == 1 || rotation == 3) {
            if (outlineY > y) {
               g.setColor(lightGreen);
               g.fillRect(x, outlineY, 40, 80);
               g.fillRect(x - 40, outlineY - 40, 40, 80);
            }
            g.setColor(Color.GREEN);
            g.fillRect(x, y, 40, 80);
            g.fillRect(x - 40, y - 40, 40, 80);
         }
      }
      if (shape == 7) {
         if (rotation == 0 || rotation == 2) {
            if (outlineY > y) {
               g.setColor(lightRed);
               g.fillRect(x, outlineY, 80, 40);
               g.fillRect(x + 40, outlineY + 40, 80, 40);
            }
            g.setColor(Color.RED);
            g.fillRect(x, y, 80, 40);
            g.fillRect(x + 40, y + 40, 80, 40);
         }
         if (rotation == 1 || rotation == 3) {
            if (outlineY > y) {
               g.setColor(lightRed);
               g.fillRect(x, outlineY, 40, 80);
               g.fillRect(x - 40, outlineY + 40, 40, 80);
            }
            g.setColor(Color.RED);
            g.fillRect(x, y, 40, 80);
            g.fillRect(x - 40, y + 40, 40, 80);
         }
      }
      for (int i = 0; i < board.length; i++) { 
         for (int j = 0; j < board[i].length; j++) { 
            if (board[i][j] == 1) {
               g.setColor(Color.YELLOW);
               g.fillRect(j * 40, i * 40, 40, 40);
            }
            if (board[i][j] == 2) {
               g.setColor(Color.CYAN);
               g.fillRect(j * 40, i * 40, 40, 40);
            }
            if (board[i][j] == 3) {
               g.setColor(Color.MAGENTA);
               g.fillRect(j * 40, i * 40, 40, 40);
            }
            if (board[i][j] == 4) {
               g.setColor(Color.ORANGE);
               g.fillRect(j * 40, i * 40, 40, 40);
            }
            if (board[i][j] == 5) {
               g.setColor(Color.BLUE);
               g.fillRect(j * 40, i * 40, 40, 40);
            }
            if (board[i][j] == 6) {
               g.setColor(Color.GREEN);
               g.fillRect(j * 40, i * 40, 40, 40);
            }
            if (board[i][j] == 7) {
               g.setColor(Color.RED);
               g.fillRect(j * 40, i * 40, 40, 40);
            }
         }
      }
      for (int i = 0; i < shapes.length; i++) {
         if (shapes[i] == 1) {
            g.setColor(Color.YELLOW);
            g.fillRect(450, (i * 80) + 20 + 20, 40, 40);
         }
         if (shapes[i] == 2) {
            g.setColor(Color.CYAN);
            g.fillRect(450 + 20, (i * 80) + 20, 20, 80);
         }
         if (shapes[i] == 3) {
            g.setColor(Color.MAGENTA);
            g.fillRect(450, (i * 80) + 20 + 20, 60, 20);
            g.fillRect(450 + 20, (i * 80) + 20 + 20 + 20, 20, 20);
         }
         if (shapes[i] == 4) {
            g.setColor(Color.ORANGE);
            g.fillRect(450 + 20, (i * 80) + 20 + 20, 20, 60);
            g.fillRect(450 - 20 + 20, (i * 80) + 20 + 20, 20, 20);
         }
         if (shapes[i] == 5) {
            g.setColor(Color.BLUE);
            g.fillRect(450, (i * 80) + 20 + 20, 20, 60);
            g.fillRect(450 + 20, (i * 80) + 20 + 20, 20, 20);
         }
         if (shapes[i] == 6) {
            g.setColor(Color.GREEN);
            g.fillRect(450 + 20, (i * 80) + 20 + 20, 40, 20);
            g.fillRect(450 - 20 + 20, (i * 80) + 20 + 20 + 20, 40, 20);
         }
         if (shapes[i] == 7) {
            g.setColor(Color.RED);
            g.fillRect(450, (i * 80) + 20 + 20, 40, 20);
            g.fillRect(450 + 20, (i * 80) + 20 + 20 + 20, 40, 20);
         }
      }
      if (hold == 1) {
         g.setColor(Color.YELLOW);
         g.fillRect(450, 360 + 20 + 20 + 80, 40, 40);
      }
      if (hold == 2) {
         g.setColor(Color.CYAN);
         g.fillRect(450 + 20, 360 + 20 + 80, 20, 80);
      }
      if (hold == 3) {
         g.setColor(Color.MAGENTA);
         g.fillRect(450, 360 + 20 + 20 + 80, 60, 20);
         g.fillRect(450 + 20, 360 + 20 + 20 + 20 + 80, 20, 20);
      }
      if (hold == 4) {
         g.setColor(Color.ORANGE);
         g.fillRect(450 + 20, 360 + 20 + 20 + 80, 20, 60);
         g.fillRect(450 - 20 + 20, 360 + 20 + 20 + 80, 20, 20);
      }
      if (hold == 5) {
         g.setColor(Color.BLUE);
         g.fillRect(450, 360 + 20 + 20 + 80, 20, 60);
         g.fillRect(450 + 20, 360 + 20 + 20 + 80, 20, 20);
      }
      if (hold == 6) {
         g.setColor(Color.GREEN);
         g.fillRect(450 + 20, 360 + 20 + 20 + 80, 40, 20);
         g.fillRect(450 - 20 + 20, 360 + 20 + 20 + 20 + 80, 40, 20);
      }
      if (hold == 7) {
         g.setColor(Color.RED);
         g.fillRect(450, 360 + 20 + 20 + 80, 40, 20);
         g.fillRect(450 + 20, 360 + 20 + 20 + 20 + 80, 40, 20);
      }
   }
   
   public void freeze() {
      if (shape == 1) {//SQUARE
         board[(y / 40) + 1][(x / 40)] = 1;     //bottom left   
         board[(y / 40) + 1][(x / 40) + 1] = 1; //bottom right
         board[(y / 40)][(x / 40)] = 1;         //top left
         board[(y / 40)][(x / 40) + 1] = 1;     //top right
      }
      if (shape == 2) {//LINE
         if (rotation == 0 || rotation == 2) {
            board[(y / 40)][(x / 40)] = 2;      //top
            board[(y / 40) + 1][(x / 40)] = 2;  //second to top
            board[(y / 40) + 2][(x / 40)] = 2;  //second to bottom
            board[(y / 40) + 3][(x / 40)] = 2;  //bottom
         }
         if (rotation == 1 || rotation == 3) {
            board[(y / 40)][(x / 40)] = 2;      //left
            board[(y / 40)][(x / 40) + 1] = 2;  //second from left
            board[(y / 40)][(x / 40) + 2] = 2;  //second from right
            board[(y / 40)][(x / 40) + 3] = 2;  //right
         }
      }
      if (shape == 3) {//T
         if (rotation == 0) {
            board[(y / 40)][(x / 40)] = 3;         //top right
            board[(y / 40)][(x / 40) + 1] = 3;     //top middle
            board[(y / 40)][(x / 40) + 2] = 3;     //top left
            board[(y / 40) + 1][(x / 40) + 1] = 3; //bottom
         }
         if (rotation == 1) {
            board[(y / 40)][(x / 40)] = 3;
            board[(y / 40) + 1][(x / 40)] = 3;
            board[(y / 40) + 2][(x / 40)] = 3;
            board[(y / 40) + 1][(x / 40) - 1] = 3;
         }
         if (rotation == 2) {
            board[(y / 40)][(x / 40)] = 3;         
            board[(y / 40)][(x / 40) + 1] = 3;     
            board[(y / 40)][(x / 40) + 2] = 3;     
            board[(y / 40) - 1][(x / 40) + 1] = 3; 
         }
         if (rotation == 3) {
            board[(y / 40)][(x / 40)] = 3;
            board[(y / 40) + 1][(x / 40)] = 3;
            board[(y / 40) + 2][(x / 40)] = 3;
            board[(y / 40) + 1][(x / 40) + 1] = 3;
         }
      }
      if (shape == 4) {// ORANGE L
         if (rotation == 0) {
            board[(y / 40)][(x / 40)] = 4;
            board[(y / 40) + 1][(x / 40)] = 4;
            board[(y / 40) + 2][(x / 40)] = 4;
            board[(y / 40)][(x / 40) - 1] = 4;
         }
         if (rotation == 1) {
            board[(y / 40)][(x / 40)] = 4;
            board[(y / 40)][(x / 40) + 1] = 4;
            board[(y / 40)][(x / 40) + 2] = 4;
            board[(y / 40) - 1][(x / 40) + 2] = 4;
         }
         if (rotation == 2) {
            board[(y / 40)][(x / 40)] = 4;
            board[(y / 40) + 1][(x / 40)] = 4;
            board[(y / 40) + 2][(x / 40)] = 4;
            board[(y / 40) + 2][(x / 40) + 1] = 4;
         }
         if (rotation == 3) {
            board[(y / 40)][(x / 40)] = 4;
            board[(y / 40)][(x / 40) + 1] = 4;
            board[(y / 40)][(x / 40) + 2] = 4;
            board[(y / 40) + 1][(x / 40)] = 4;
         }
      }
      if (shape == 5) {// BLUE L
         if (rotation == 0) {
            board[(y / 40)][(x / 40)] = 5;
            board[(y / 40) + 1][(x / 40)] = 5;
            board[(y / 40) + 2][(x / 40)] = 5;
            board[(y / 40)][(x / 40) + 1] = 5;
         }
         if (rotation == 1) {
            board[(y / 40)][(x / 40)] = 5;
            board[(y / 40)][(x / 40) + 1] = 5;
            board[(y / 40)][(x / 40) + 2] = 5;
            board[(y / 40) + 1][(x / 40) + 2] = 5;
         }
         if (rotation == 2) {
            board[(y / 40)][(x / 40)] = 5;
            board[(y / 40) + 1][(x / 40)] = 5;
            board[(y / 40) + 2][(x / 40)] = 5;
            board[(y / 40) + 2][(x / 40) - 1] = 5;
         }
         if (rotation == 3) {
            board[(y / 40)][(x / 40)] = 5;
            board[(y / 40)][(x / 40) + 1] = 5;
            board[(y / 40)][(x / 40) + 2] = 5;
            board[(y / 40) - 1][(x / 40)] = 5;
         }
      }
      if (shape == 6) {// GREEN S
         if (rotation == 0 || rotation == 2) {
            board[(y / 40)][(x / 40)] = 6;
            board[(y / 40)][(x / 40) + 1] = 6;
            board[(y / 40) + 1][(x / 40)] = 6;
            board[(y / 40) + 1][(x / 40) - 1] = 6;
         }
         if (rotation == 1 || rotation == 3) {
            board[(y / 40)][(x / 40)] = 6;
            board[(y / 40) + 1][(x / 40)] = 6;
            board[(y / 40)][(x / 40) - 1] = 6;
            board[(y / 40) - 1][(x / 40) - 1] = 6;
         }
      }
      if (shape == 7) {// RED S
         if (rotation == 0 || rotation == 2) {
            board[(y / 40)][(x / 40)] = 7;
            board[(y / 40)][(x / 40) + 1] = 7;
            board[(y / 40) + 1][(x / 40) + 1] = 7;
            board[(y / 40) + 1][(x / 40) + 2] = 7;
         }
         if (rotation == 1 || rotation == 3) {
            board[(y / 40) + 1][(x / 40)] = 7;
            board[(y / 40)][(x / 40)] = 7;
            board[(y / 40) + 1][(x / 40) - 1] = 7;
            board[(y / 40) + 2][(x / 40) - 1] = 7;
         }
      }
      for (int i = 0; i < 20; i++) {
         if (board[i][0] != 0 && board[i][1] != 0 && board[i][2] != 0 && board[i][3] != 0 && board[i][4] != 0 && board[i][5] != 0 && board[i][6] != 0 && board[i][7] != 0 && board[i][8] != 0 && board[i][9] != 0) {
            for (int j = 0; j < 10; j++) {
               board[i][j] = 0;
            }
            score++;
            delete(i);
         }
      }
      for (int i = 0; i < 10; i++) {
         if (board[0][i] != 0) {
            gameOver = true;
         }
      }
      y = 0;
      x = 160;
      outlineY = 0;
      rotation = 0;
      shape = shapes[0];
      for (int i = 0; i < 4; i++) {
         shapes[i] = shapes[i + 1];
      }
      shapes[4] = (int)(Math.random() * 7) + 1;
      System.out.println(score);
   }

   public void swap() {
      if (hold == 0) {
         hold = shape;
         shape = shapes[0];
         for (int i = 0; i < 4; i++) {
            shapes[i] = shapes[i + 1];
         }
         shapes[4] = (int)(Math.random() * 7) + 1;
      } else {
         int temp = shape;
         shape = hold;
         hold = temp;

      }
   }

   public void delete(int row) {
      for (int i = row; i >= 1; i--) {
         for (int j = 0; j < 10; j++) {
            board[i][j] = board[i - 1][j];
         }
      }
   }

   public int getScore() {
      return score;
   }

   public boolean getGameStatus() {
      return gameOver;
   }
      
   public void move() {
      if (canMove()) {
         y += 40;
      } else {
         freeze();
      }
      getFloor();
   }

   public void getFloor() {
      for (int i = 0; i < 20; i++) {
         if (canMoveOutline()) {
            outlineY += 40;
         }
      }
   }
   
   public boolean canMove() {
      if (shape == 1) {
         if (board[(y / 40) + 2][x / 40] != 0 /*bottom left*/ || board[(y / 40) + 2][(x / 40) + 1] != 0 /*bottom right*/) {
            return false;
         } else {
            return true;
         }
      }
      if (shape == 2) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40) + 4][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0 || board[(y / 40) + 1][(x / 40) + 3] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 3) {
         if (rotation == 0) {
            if (board[(y / 40) + 2][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40) + 3][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40) + 3][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 4) {
         if (rotation == 0) {
            if (board[(y / 40) + 3][(x / 40)] != 0 ||  board[(y / 40) + 1][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40) + 3][(x / 40)] != 0 ||  board[(y / 40) + 3][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40) + 2][(x / 40)] != 0 ||  board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 5) {
         if (rotation == 0) {
            if (board[(y / 40) + 3][(x / 40)] != 0 ||  board[(y / 40) + 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40) + 2][(x / 40) + 2] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40) + 3][(x / 40)] != 0 ||  board[(y / 40) + 3][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40) + 1][(x / 40)] != 0 ||  board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 6) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40) - 1] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 7) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0 || board[(y / 40) + 2][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40) + 3][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      return false;
   }

   public boolean canMoveRight() {
      if (shape == 1) {
         if (board[(y / 40) + 1][(x / 40) + 2] != 0 /*bottom right*/ || board[(y / 40)][(x / 40) + 2] != 0 /*top right*/) {
            return false;
         } else {
            return true;
         }
      }
      if (shape == 2) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0 || board[(y / 40) + 3][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40)][(x / 40) + 4] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 3) {
         if (rotation == 0) {
            if (board[(y / 40)][(x / 40) + 3] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40)][(x / 40) + 3] != 0 || board[(y / 40) - 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40) + 1][(x / 40) + 2] != 0 || board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 4) {
         if (rotation == 0) {
            if (board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40)][(x / 40) + 3] != 0 || board[(y / 40) - 1][(x / 40) + 3] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 2][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40)][(x / 40) + 3] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 5) {
         if (rotation == 0) {
            if (board[(y / 40)][(x / 40) + 2] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40)][(x / 40) + 3] != 0 || board[(y / 40) + 1][(x / 40) + 3] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40)][(x / 40) + 3] != 0 || board[(y / 40) - 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 6) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40)][(x / 40) + 2] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) - 1][(x / 40)] != 0)  {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 7) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40)][(x / 40) + 2] != 0 || board[(y / 40) + 1][(x / 40) + 3] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 2][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      return false;
   }

   public boolean canMoveLeft() {
      if (shape == 1) {
         if (board[(y / 40) + 1][(x / 40) - 1] != 0 /*bottom left*/ || board[(y / 40)][(x / 40) - 1] != 0 /*top left*/) {
            return false;
         } else {
            return true;
         }
      }
      if (shape == 2) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) + 1][(x / 40) - 1] != 0 || board[(y / 40) + 2][(x / 40) - 1] != 0 || board[(y / 40) + 3][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40)][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 3) {
         if (rotation == 0) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) + 1][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40) + 1][(x / 40) - 2] != 0 || board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) + 2][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) + 1][(x / 40) - 1] != 0 || board[(y / 40) + 2][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 4) {
         if (rotation == 0) {
            if (board[(y / 40)][(x / 40) - 2] != 0 || board[(y / 40) + 1][(x / 40) - 1 ] != 0 || board[(y  / 40) + 2][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) - 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) + 1][(x / 40) - 1 ] != 0 || board[(y / 40) + 2][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) + 1][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 5) {
         if (rotation == 0) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) + 1][(x / 40) - 1] != 0 || board[(y / 40) + 2][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40) + 2][(x / 40) - 2] != 0 || board[(y / 40) + 1][(x / 40) - 1 ] != 0 || board[(y / 40)][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) - 1][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 6) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40) + 1][(x / 40) - 2] != 0 || board[(y / 40)][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40) + 1][(x / 40) - 1] != 0 || board[(y / 40)][(x / 40) - 2] != 0 || board[(y / 40) - 1][(x / 40) - 2] != 0)  {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 7) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) + 1][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) + 1][(x / 40) - 2] != 0 || board[(y / 40) + 2][(x / 40) - 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      return false;
   }

   public boolean canRotate() {
      if (shape == 1) {
         return false;
      }
      if (shape == 2) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40)][(x / 40) + 2] != 0 || board[(y / 40)][(x / 40) + 3] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40) + 3][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 3) {
         if (rotation == 0) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40)][(x / 40) + 2] != 0 || board[(y / 40) - 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40)][(x / 40) + 2] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 4) {
         if (rotation == 0) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40)][(x / 40) + 2] != 0 || board[(y / 40) - 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40)][(x / 40) + 2] != 0 || board[(y / 40) + 1][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40)][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 5) {
         if (rotation == 0) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40)][(x / 40) + 2] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40)][(x / 40) + 2] != 0 || board[(y / 40) - 1][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40)][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 6) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40)][(x / 40) - 1] != 0 || board[(y / 40) - 1][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 7) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40)][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) - 1] != 0 || board[(y / 40) + 2][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40)][(x / 40)] != 0 || board[(y / 40)][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      return false;
   }

   public boolean canMoveOutline() {
      if (shape == 1) {
         if (board[(outlineY / 40) + 2][x / 40] != 0 /*bottom left*/ || board[(outlineY / 40) + 2][(x / 40) + 1] != 0 /*bottom right*/) {
            return false;
         } else {
            return true;
         }
      }
      if (shape == 2) {
         if (rotation == 0 || rotation == 2) {
            if (board[(outlineY / 40) + 4][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(outlineY / 40) + 1][(x / 40)] != 0 || board[(outlineY / 40) + 1][(x / 40) + 1] != 0 || board[(outlineY / 40) + 1][(x / 40) + 2] != 0 || board[(outlineY / 40) + 1][(x / 40) + 3] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 3) {
         if (rotation == 0) {
            if (board[(outlineY / 40) + 2][(x / 40) + 1] != 0 || board[(outlineY / 40) + 1][(x / 40)] != 0 || board[(outlineY / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(outlineY / 40) + 3][(x / 40)] != 0 || board[(outlineY / 40) + 2][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(outlineY / 40) + 1][(x / 40)] != 0 || board[(outlineY / 40) + 1][(x / 40) + 1] != 0 || board[(outlineY / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(outlineY / 40) + 3][(x / 40)] != 0 || board[(outlineY / 40) + 2][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 4) {
         if (rotation == 0) {
            if (board[(outlineY / 40) + 3][(x / 40)] != 0 ||  board[(outlineY / 40) + 1][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(outlineY / 40) + 1][(x / 40)] != 0 || board[(outlineY / 40) + 1][(x / 40) + 1] != 0 || board[(outlineY / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(outlineY / 40) + 3][(x / 40)] != 0 ||  board[(outlineY / 40) + 3][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(outlineY / 40) + 2][(x / 40)] != 0 ||  board[(outlineY / 40) + 1][(x / 40) + 1] != 0 || board[(outlineY / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 5) {
         if (rotation == 0) {
            if (board[(outlineY / 40) + 3][(x / 40)] != 0 ||  board[(outlineY / 40) + 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(outlineY / 40) + 2][(x / 40) + 2] != 0 || board[(outlineY / 40) + 1][(x / 40) + 1] != 0 || board[(outlineY / 40) + 1][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(outlineY / 40) + 3][(x / 40)] != 0 ||  board[(outlineY / 40) + 3][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(outlineY / 40) + 1][(x / 40)] != 0 ||  board[(outlineY / 40) + 1][(x / 40) + 1] != 0 || board[(outlineY / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 6) {
         if (rotation == 0 || rotation == 2) {
            if (board[(outlineY / 40) + 2][(x / 40)] != 0 || board[(outlineY / 40) + 2][(x / 40) - 1] != 0 || board[(outlineY / 40) + 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(outlineY / 40) + 2][(x / 40)] != 0 || board[(outlineY / 40) + 1][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (shape == 7) {
         if (rotation == 0 || rotation == 2) {
            if (board[(outlineY / 40) + 1][(x / 40)] != 0 || board[(outlineY / 40) + 2][(x / 40) + 1] != 0 || board[(outlineY / 40) + 2][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(outlineY / 40) + 2][(x / 40)] != 0 || board[(outlineY / 40) + 3][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      return false;
   }

   public boolean canSwap() {
      if (hold == 1) {
         if (board[(y / 40) + 2][x / 40] != 0 /*bottom left*/ || board[(y / 40) + 2][(x / 40) + 1] != 0 /*bottom right*/) {
            return false;
         } else {
            return true;
         }
      }
      if (hold == 2) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40) + 4][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0 || board[(y / 40) + 1][(x / 40) + 3] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (hold == 3) {
         if (rotation == 0) {
            if (board[(y / 40) + 2][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40) + 3][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40) + 3][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (hold == 4) {
         if (rotation == 0) {
            if (board[(y / 40) + 3][(x / 40)] != 0 ||  board[(y / 40) + 1][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40) + 3][(x / 40)] != 0 ||  board[(y / 40) + 3][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40) + 2][(x / 40)] != 0 ||  board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (hold == 5) {
         if (rotation == 0) {
            if (board[(y / 40) + 3][(x / 40)] != 0 ||  board[(y / 40) + 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1) {
            if (board[(y / 40) + 2][(x / 40) + 2] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40)] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 2) {
            if (board[(y / 40) + 3][(x / 40)] != 0 ||  board[(y / 40) + 3][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 3) {
            if (board[(y / 40) + 1][(x / 40)] != 0 ||  board[(y / 40) + 1][(x / 40) + 1] != 0 || board[(y / 40) + 1][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (hold == 6) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40) - 1] != 0 || board[(y / 40) + 1][(x / 40) + 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40) + 1][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      if (hold == 7) {
         if (rotation == 0 || rotation == 2) {
            if (board[(y / 40) + 1][(x / 40)] != 0 || board[(y / 40) + 2][(x / 40) + 1] != 0 || board[(y / 40) + 2][(x / 40) + 2] != 0) {
               return false;
            } else {
               return true;
            }
         }
         if (rotation == 1 || rotation == 3) {
            if (board[(y / 40) + 2][(x / 40)] != 0 || board[(y / 40) + 3][(x / 40) - 1] != 0) {
               return false;
            } else {
               return true;
            }
         }
      }
      return true;
   }

   public void keyPressed(KeyEvent e) {
      if ((e.getKeyCode() == KeyEvent.VK_RIGHT)) {
         if (canMoveRight()) {
            x += 40;
            outlineY = 0;
            getFloor();
         }
         tetris.repaint();
      }
      if ((e.getKeyCode() == KeyEvent.VK_LEFT)) {
         if (canMoveLeft()) {
            x -= 40;
            outlineY = 0;
            getFloor();
         }
         tetris.repaint();
      }
      if ((e.getKeyCode() == KeyEvent.VK_DOWN)) {
         if (canMove()) {
            y += 40;
         }
         tetris.repaint();
      }
      if ((e.getKeyCode() == KeyEvent.VK_UP)) {
         if (canRotate()) {
            if (rotation < 3) {
               rotation++;
            } else {
               rotation = 0;
            }
            outlineY = 0;
            getFloor();
         }
         tetris.repaint();
      }
      if ((e.getKeyCode() == KeyEvent.VK_SPACE)) {
         if (outlineY > y) {
            y = outlineY;
            tetris.repaint();
            move();
         }
      }
      if ((e.getKeyCode() == KeyEvent.VK_C)) {
         if (canSwap()) {
            swap();
            outlineY = 0;
            getFloor();
            tetris.repaint();
         }
      }
   }
}
