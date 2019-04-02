package org.academiadecodigo.mainiacs.code;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BadCode extends Code {


    private Picture badCode;
    private int mov = 0;
    private int speed = 200;
    private static final int PADDING = 10;
    private int posY = PADDING;
    private int posX;

    public BadCode(){
        super();
        posX = (int)((Math.random()*410)+160);
        badCode = new Picture(posX, PADDING, "./resources/badCode.jpg");
        badCode.draw();


    }

    public void move() throws InterruptedException{
        int x = 0;
        while(x < 34) {
            badCode.translate(0, mov);
            mov += 1;
            Thread.sleep(speed);
            x++;
            posY = posY + mov;
        }
        Thread.sleep(50);
        badCode.delete();
    }

    public void setSpeed() {
        speed = speed*10;
    }


    public int getPosY(){
        return posY;
    }

    @Override
    public int getPosX() {
        return posX;
    }

    public int getMov(){
        return mov;
    }

    public String toString(){
        return "B";
    }
}