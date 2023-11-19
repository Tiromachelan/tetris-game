# tetris-game
Tetris coded in Java using Swing and Abstract Web Toolkit for graphics

See the game in action here: https://youtu.be/WIlRIhOPBxI?si=tg9mL79E4ZCpGvfa

To run, ensure that all files are in the same folder.  Then compile and run Tetris.java.

The following error may occur in some (rare) cases when the program is closed before it has a chance to write the high score to the txt file. If you get the following error:

Exception in thread "main" java.util.NoSuchElementException
        at java.base/java.util.Scanner.throwFor(Scanner.java:937)
        at java.base/java.util.Scanner.next(Scanner.java:1594)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at Tetris.main(Tetris.java:11)

This means that the integer saved in highscore.txt was deleted; just add an integer to that file and it should work again.  You may notice other exceptions in the terminal; this is normal and does not affect the game.

Right arrow to move the piece right

Left arrow to move the piece left

Up arrow to rotate the piece (note that the piece will not rotate if it is too close to another piece, or any of the 4 borders of the grid)

Down arrow to move the piece down

Spacebar to instantly drop the piece

C to swap pieces (only works if there is space for the new piece)

Pieces may not rotate if they are too close to a wall or another piece.
