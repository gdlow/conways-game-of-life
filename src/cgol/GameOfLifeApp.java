package cgol;

public class GameOfLifeApp {
    public GameOfLifeApp(String fileName) {
        //700,600 recommended
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
        // Run from root directory: java -cp out/production/cgol cgol.GameOfLifeApp -fileName
        String fileName = args[0];
        new GameOfLifeApp(fileName);
    }
}
