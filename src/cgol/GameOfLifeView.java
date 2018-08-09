package cgol;

public interface GameOfLifeView {
    public int getHeight();
    public int getWidth();
    public void drawGeneration(final boolean[][] generation);
}
