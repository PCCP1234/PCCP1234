package org.codeForAll.iorns.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


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

        EventHandler eventHandler = new EventHandler(this);
        this.cols = cols;
        this.player = new Player(this);
        this.rows = rows;
        eventHandler.setPlayer(player);
    }


    public Rectangle makeGrid() {
        Rectangle grid = new Rectangle(PADDING, PADDING, this.cols * squareSize, this.cols * squareSize);
        int ini = PADDING;
        while (ini <= grid.getHeight()) {
            for (int i = PADDING; i < grid.getWidth() + 1; i = (i + squareSize)) {
                Rectangle lineSquare = new Rectangle(i, ini, squareSize, squareSize);
                lineSquare.draw();
                rectangles.add(lineSquare);
            }
            ini += squareSize;
        }
        return grid;
    }


    public void paintSquare() {
        for (int i = 0; i < rectangles.size(); i++) {
            System.out.println("aqui");
            Rectangle rectangle = rectangles.get(i);
            if (rectangle.getX() == player.getPlayerPosX() && rectangle.getY() == player.getPlayerPosY()) {
                if (!rectangle.isFilled()) {
                    rectangle.setColor(Color.BLACK);
                    rectangle.fill();
                    rectanglesPaint.add(rectangle);
                } else {
                    //rectangle.delete();
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

    // não faz clear all
    public void clearAll() {
        if(!rectanglesPaint.isEmpty()) {
            rectanglesPaint.clear();
        }
    }

//Quando faço o load, depois não me deixa despintar
    public void load() {
        try {
            FileReader fileReader = null;
            try {
                fileReader = new FileReader("resources/dataSquarePaint.txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = " ";
            while ((line = bufferedReader.readLine()) != null) {
                String[] result = line.split(" ");
                Rectangle rectangle = new Rectangle(Integer.parseInt(result[0]), Integer.parseInt(result[1]), squareSize, squareSize);
                rectangle.setColor(Color.BLACK);
                rectangle.fill();
                rectanglesPaint.add(rectangle);
            }
            bufferedReader.close();


        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
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













