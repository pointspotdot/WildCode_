package org.academiadecodigo.mainiacs.code;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GoodCode extends Code {

    private Picture goodCode;
    private int mov = 0;
    private int speed = 200;
    private static final int PADDING = 10;
    private int posY = PADDING;
    private int posX;

    public GoodCode(){
        super();
        posX = (int)((Math.random()*410)+160);
        goodCode = new Picture(posX, PADDING, "./resources/goodCode.jpg");
        goodCode.draw();
    }

    public void move() throws InterruptedException{
        int x = 0;
        while(x < 34) {
            goodCode.translate(0, mov);
            mov += 1;
            Thread.sleep(speed);
            x++;
            posY = posY + mov;

        }
        Thread.sleep(50);
        goodCode.delete();
    }

    public void setSpeed() {
        speed = speed*10;
    }

    public int getPosY(){
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    @Override
    public String toString() {
        return "GoodCode{}";
    }
}
