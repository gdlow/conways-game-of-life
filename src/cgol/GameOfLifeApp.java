package cgol;

public class GameOfLifeApp {
    public GameOfLifeApp(String fileName) {
        final GameOfLifeView gameOfLifeView = new GameOfLifeViewStdDraw(700, 600);

        final GameOfLifePresenter gameOfLifePresenter = new GameOfLifePresenter(
                gameOfLifeView,
                fileName,
                ((GameOfLifeViewStdDraw) gameOfLifeView).getCentX(),
                ((GameOfLifeViewStdDraw) gameOfLifeView).getCentY()
        );
        gameOfLifePresenter.start();
    }
    public static void main(String[] args) {
        new GameOfLifeApp("VENETIAN.LIF");
    }
}