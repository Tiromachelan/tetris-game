# tetris-game
Tetris coded in Java using Swing and Abstract Web Toolkit for graphics

To run, ensure that all files are in the same folder.  Then compile and run Tetris.java.

If you get the following error:

Exception in thread "main" java.util.NoSuchElementException
        at java.base/java.util.Scanner.throwFor(Scanner.java:937)
        at java.base/java.util.Scanner.next(Scanner.java:1594)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at Tetris.main(Tetris.java:11)

This means that the integer saved in highscore.txt was deleted; just add an integer to that file and it should work again.  This happens when the game is exited before the printwriter can write the high score to the txt file (rare).

Right arrow to move the piece right

Left arrow to move the piece left

Up arrow to rotate the piece (note that the piece will not rotate if it is too close to another piece, or any of the 4 borders of the grid)

Down arrow to move the piece down

Spacebar to instantly drop the piece

C to swap pieces

