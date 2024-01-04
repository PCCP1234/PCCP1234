package org.codeForAll.iorns.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.ArrayList;


public class Grid {

    public static final int PADDING = 10;

    private boolean painting;

    private int rows;

    private int width;
    private int height;

    Player player;
    private int cols;

    public int squareSize = 20;

    ArrayList<Rectangle> rectangles = new ArrayList<>();

    ArrayList<Rectangle> rectanglesPaint = new ArrayList<>();


    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void setPlayer(Player player) {
        EventHandler eventHandler = new EventHandler(this);
        eventHandler.setPlayer(player);
        this.player = player;

    }

    public void makeGrid() {
        Rectangle grid = new Rectangle(PADDING, PADDING, this.cols * squareSize, this.cols * squareSize);
        int ini = PADDING;
        while (ini <= grid.getHeight()) {
            for (int i = PADDING; i < grid.getWidth() + 1; i = (i + squareSize)) {
                Rectangle rectangle = new Rectangle(i, ini, squareSize, squareSize);
                rectangle.draw();
                rectangles.add(rectangle);
            }
            ini += squareSize;
        }
    }


    public void paintSquare() {
        for (int i = 0; i < rectangles.size(); i++) {
            Rectangle rectangle = rectangles.get(i);
            if (rectangle.getX() == player.getPlayerPosX() && rectangle.getY() == player.getPlayerPosY()) {
                if (!rectangle.isFilled()) {
                    rectangle.setColor(Color.BLACK);
                    rectangle.fill();
                    rectanglesPaint.add(rectangle);
                } else {
                    rectangle.draw();
                    rectanglesPaint.remove(rectangle);

                }
            }
        }
    }


    public void save() {
        try {
            FileWriter fileWriter = new FileWriter("resources/dataSquarePaint.txt");
            for (Rectangle rectangle : rectanglesPaint) {
                fileWriter.write(rectangle.getX() + " " + rectangle.getY() + "\n");
            }
            fileWriter.close();
            System.out.println("Data was successfully saved");
        } catch (IOException e) {
            System.out.println("An error was found: " + e.getMessage());
        }
    }

    public void delete() {
        for (Rectangle rectangle : rectanglesPaint) {
            rectangle.draw();
        }
    }


    public void clearAll() {
        for (Rectangle rectangle: rectanglesPaint) {
            rectangle.draw();
        }
            rectanglesPaint.clear();
        System.out.println(rectanglesPaint);
    }


    public void load() {
        try {
            FileReader fileReader = null;
            try {
                fileReader = new FileReader("resources/dataSquarePaint.txt");
            } catch (FileNotFoundException e) {
                e.getMessage();
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = " ";
            while ((line = bufferedReader.readLine()) != null) {
                String[] result = line.split(" ");
                Rectangle rectangle = getRectanglePosGrid(Integer.parseInt(result[0]),Integer.parseInt(result[1]));
                rectangle.setColor(Color.BLACK);
                rectangle.fill();
                rectanglesPaint.add(rectangle);
            }
            bufferedReader.close();

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Rectangle getRectanglePosGrid(int x, int y){
        for (Rectangle rectangle: rectangles) {
            if (rectangle.getX() == x & rectangle.getY() == y) {
                return rectangle;
            }
        }
        return null;
    }


    public int getHeight() {
        height = this.rows * squareSize + PADDING;
        return height;
    }

    public int getWidth() {
        width = this.cols * squareSize + PADDING;
        return width;
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }
}













