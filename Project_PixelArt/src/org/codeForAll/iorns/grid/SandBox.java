package org.codeForAll.iorns.grid;

import java.io.FileNotFoundException;

public class SandBox {

    public static void main(String[] args) throws FileNotFoundException {

        Grid grid = new Grid(20,20);

        grid.makeGrid();
        grid.setPlayer(new Player(grid));

    }
}
