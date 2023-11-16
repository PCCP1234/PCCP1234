package org.codeForAll.iorns.grid;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class EventHandler implements KeyboardHandler {

    Player player;

    Grid grid;

    private int rows;

    private int cols;

    public EventHandler(Grid grid){
        this.grid = grid;
        init();
    }




    public void init() {

        Keyboard aa = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        aa.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        aa.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        aa.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        aa.addEventListener(down);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);

        aa.addEventListener(space);

        KeyboardEvent sKey = new KeyboardEvent();
        sKey.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        sKey.setKey(KeyboardEvent.KEY_S);

        aa.addEventListener(sKey);

        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);

        aa.addEventListener(load);

        KeyboardEvent delete = new KeyboardEvent();
        delete.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        delete.setKey(KeyboardEvent.KEY_D);

        aa.addEventListener(delete);

        KeyboardEvent clearAll = new KeyboardEvent();
        clearAll.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clearAll.setKey(KeyboardEvent.KEY_C);

        aa.addEventListener(clearAll);
    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                player.moveRight();
                break;
            case KeyboardEvent.KEY_LEFT:
                player.moveLeft();
                break;
            case KeyboardEvent.KEY_UP:
                player.moveUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                player.moveDown();
                break;
            case KeyboardEvent.KEY_SPACE:
                grid.setPainting(true);
                grid.paintSquare();
                break;
            case KeyboardEvent.KEY_S:
                grid.save();
                break;
            case KeyboardEvent.KEY_L:
                grid.load();
                break;
            case KeyboardEvent.KEY_D:
                grid.delete();
                break;
            case KeyboardEvent.KEY_C:
                grid.clearAll();
                break;
        }
    }


        @Override
        public void keyReleased (KeyboardEvent keyboardEvent){
             if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
                grid.setPainting(false);
            }
        }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
