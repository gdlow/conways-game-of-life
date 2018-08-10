package cgol;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GameOfLifePatterns {
    private boolean[][] currentGeneration;

    public GameOfLifePatterns(boolean[][] currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    /**
     * Patterns in Conway's Game of Life
     */

    public void patternRandom() {
        final Random random = new Random();
        for (int row = 0; row < currentGeneration.length; ++row) {
            for (int col = 0; col < currentGeneration[row].length; ++col) {
                currentGeneration[row][col] = random.nextBoolean();
            }
        }
    }

    public void readPatternFromFile(String fileName, int centX, int centY) {
        try {
            File patternFile = new File(String.format("resources/%s", fileName));
            FileReader fileReader = new FileReader(patternFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            int i = 0;
            String[][] patternContainer = new String[1000][500];
            ArrayList<Integer> xCoord = new ArrayList<>();
            ArrayList<Integer> yCoord = new ArrayList<>();


            while ((line = reader.readLine()) != null) {
                int j = 0;
                if (line.startsWith("#D")) {
                    line = line.replaceAll("#D ", "");
                    System.out.println(line);
                }
                else if (line.startsWith("#P")) {
                    String[] parts = line.split(" ");
                    xCoord.add(centX + Integer.parseInt(parts[1]));
                    yCoord.add(centY - Integer.parseInt(parts[2]));

                    //Read the next line
                    String patternLine = null;
                    while ((patternLine = reader.readLine()) != null) {
                        if (patternLine.startsWith("*") || patternLine.startsWith(".")) {
                            //Insert line::string into container
                            patternContainer[i][j] = patternLine;
                        }
                        else if (patternLine.startsWith("#P")) {
                            parts = patternLine.split(" ");
                            xCoord.add(centX + Integer.parseInt(parts[1]));
                            yCoord.add(centY - Integer.parseInt(parts[2]));
                            //Moves on to next pattern in file
                            j = 0;
                            i++;
                            continue;
                        }

                        //Moves on to the next line
                        j++;
                    }
                }
            }
            reader.close();


            // Draw it on the canvas
            int numOfPatterns = 0;
            int fRow;
            int fCol;
            for (int index = 0; index < yCoord.size(); index ++) {
                //For each pattern object
                if (patternContainer[index][0] != null) {
                    ++numOfPatterns;
                    //Draw Pattern
                    fCol = yCoord.get(index);
                    for (int ln = 0; ln < patternContainer[index].length; ++ln) {
                        if (patternContainer[index][ln] != null) {
                            //For every line in the corresponding pattern
                            fRow = xCoord.get(index);

                            //For every character in the line
                            for (char item : patternContainer[index][ln].toCharArray()) {
                                if (item == '*') {
                                    currentGeneration[fCol][fRow] = true;
                                }
                                fRow++;
                            }
                            fCol--;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
