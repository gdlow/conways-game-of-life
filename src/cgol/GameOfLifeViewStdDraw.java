package cgol;


public class GameOfLifeViewStdDraw implements GameOfLifeView {

    private final int width;
    private final int height;

    public GameOfLifeViewStdDraw(final int width, final int height) {
        if (width < 1) {
            throw new IllegalArgumentException("width must be a positive value");
        }
        if (height < 1) {
            throw new IllegalArgumentException("height must be a positive value");
        }
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(width, height);
        StdDraw.setYscale(0, height);
        StdDraw.setXscale(0, width);
        StdDraw.setPenRadius(0);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getCentX(){
        return width / 2;
    }

    public int getCentY() {
        return height / 2;
    }

    //Draws the given generation to the screen
    public void drawGeneration(final boolean[][] generation) {
        StdDraw.show(0);
        StdDraw.clear();
        for(int row = 0; row < generation.length; row++) {
            for(int col = 0; col < generation[row].length; col++) {
                if (generation[row][col] == true) {
                    StdDraw.point(col, row);
                }
            }
        }
        StdDraw.show(0);
    }

}
