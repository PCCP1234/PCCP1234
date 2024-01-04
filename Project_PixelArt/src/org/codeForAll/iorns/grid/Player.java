package org.codeForAll.iorns.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.FileNotFoundException;

public class Player {
    Rectangle player;


    Grid grid;
    public Player(Grid grid) {
        this.grid = grid;
        player = new Rectangle(Grid.PADDING, Grid.PADDING, grid.squareSize, grid.squareSize);
        player.setColor(Color.GREEN);
        player.fill();

    }

    public void moveRight() {
        if (getPlayerPosX() < grid.getWidth() - grid.squareSize) {
            player.translate(grid.squareSize, 0);
        }
    }
        public void moveLeft () {
            if (getPlayerPosX() > grid.squareSize){
                player.translate(-grid.squareSize, 0);
        }
        }
        public void moveUp () {
        if(getPlayerPosY() > grid.squareSize) {
            player.translate(0, -grid.squareSize);
        }
        }
        public void moveDown () {
            if(getPlayerPosY() < grid.getHeight()- grid.squareSize) {
            player.translate(0, grid.squareSize);
        }
        }

        public int getPlayerPosX () {
            return player.getX();
        }

        public int getPlayerPosY () {
            return player.getY();
        }

        public void setGrid(Grid grid){
        this.grid = grid;
        }

    }
