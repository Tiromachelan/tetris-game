# tetris-game
Tetris coded in Java using Swing and Abstract Web Toolkit for graphics

For some reason keyboard input does not work consistently on my Windows 11 machine, but works fine on Linux.  I'd like to fix this sometime in the future.  For best results on Windows 11, make sure that the game is in focus and wait ~5 seconds after running the program to make your first keyboard input.  I have found this to work sometimes, but not always.

To run, ensure that all files are in the same folder.  Then compile and run Tetris.java.  Do not attempt to close or quit the program while it is running, as it will not save the high score and will result in the following error the next time you run it.  Instead, repeatedly hit the spacebar until the game ends.

If you get the following error:

Exception in thread "main" java.util.NoSuchElementException
        at java.base/java.util.Scanner.throwFor(Scanner.java:937)
        at java.base/java.util.Scanner.next(Scanner.java:1594)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        at Tetris.main(Tetris.java:11)

This means that the integer saved in highscore.txt was deleted; just add an integer to that file and it should work again.

Right arrow to move the piece right

Left arrow to move the piece left

Up arrow to rotate the piece (note that the piece will not rotate if it is too close to another piece, or any of the 4 borders of the grid)

Down arrow to move the piece down

Spacebar to instantly drop the piece

C to swap pieces

