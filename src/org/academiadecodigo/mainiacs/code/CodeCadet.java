package org.academiadecodigo.mainiacs.code;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CodeCadet extends Code implements KeyboardHandler {

    private Picture codeCadet;
    private int mov = 0;
    private int posX = 340;
    private int posY = 570;
    private int width;





    public CodeCadet(){
        super();
        width = 60;
        codeCadet = new Picture(posX, posY, "./resources/codecadet.jpg");
        codeCadet.draw();
        move();
    }

    public void move(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        /*

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        */

    }

    /*
    public void move() throws InterruptedException{


    }
    */

    @Override
    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setSpeed(){

    }
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int limLeft = 140;
        int limRight = 550;
        int movL = -10;
        int movR = 10;

        switch(keyboardEvent.getKey()){

            case KeyboardEvent.KEY_LEFT:

                    if(posX +movL > limLeft) {
                        codeCadet.translate(movL, 0);
                        posX = posX +movL;
                        break;
                    }
                break;

            case KeyboardEvent.KEY_RIGHT:

                if(posX + movR < limRight) {
                    codeCadet.translate(movR, 0);
                    posX = posX +movR;
                    break;
                }

                break;
            /*
            case KeyboardEvent.KEY_UP:
                codeCadet.translate(0,-10);
                break;

            case KeyboardEvent.KEY_DOWN:
                codeCadet.translate(0,10);
                break;

                */
        }

    }

    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                //  mario.translate(0,100);
                //  mario2.translate(0,100);
        }

    }
}