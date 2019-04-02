package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.code.*;
import org.academiadecodigo.mainiacs.master.MasterTypeFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Game implements KeyboardHandler {


    private Code codeCadet;
    private int manufacturedCode = 100;
    private Rectangle rectangle;
    private static int PADDING = 10;
    private Picture background;
    private int col = 600;
    private Picture picStart;
    private boolean continuar = false;
    private Picture picInstru = new Picture(PADDING,PADDING, "./resources/Instructions.JPG");
    private Picture[] picCoffee;
    private int manufacturedCoffee = 6;
    private Picture[] master = new Picture[manufacturedCode];
    private int posY = 20;
    private int posX = 30;
    private int posYY = 60;
    private int posXX = 30;
    private int week = 0;
    private Music music;
    private String score = String.valueOf(week);
    private Text counter = new Text(70, 130, score);
    private Picture picLose = new Picture(PADDING, PADDING, "./resources/Lose.JPG");
    private Picture picWin = new Picture(PADDING, PADDING, "./resources/Win.JPG");
    private boolean gameover = false;
    private boolean collision;
    private Code[] code = new Code[manufacturedCode];
    private Picture picJava;
    private boolean restart = false;


    public void start() throws InterruptedException{

        if(restart == false) {
            while (continuar == false) {
                startScreen();
            }

            music = new Music();
            music.startMusic();

            Thread.sleep(100);
            picInstru.draw();
            Thread.sleep(5000);
            picInstru.delete();


            picCoffee = new Picture[manufacturedCoffee];
            background = new Picture(PADDING, PADDING, "./resources/background.jpg");
            background.draw();
            rectangle = new Rectangle(PADDING, PADDING, 600, col);
            rectangle.draw();
            picJava = new Picture(10, 200, "./resources/java.jpg");
            picJava.draw();

            codeCadet = new CodeCadet();

            for (int z = 0; z < manufacturedCoffee; z++) {
                if (z < 3) {
                    picCoffee[z] = new Picture(posX + 1, posY + 1, "./resources/coffee.png");
                    picCoffee[z].draw();
                    posX += 30;
                } else {
                    picCoffee[z] = new Picture(posXX + 1, posYY + 1, "./resources/coffee.png");
                    picCoffee[z].draw();
                    posXX += 30;
                }
            }

            while (gameover == false) {
                counter.grow(20, 20);
                int count = 0;
                while (count < manufacturedCode) {
                    for (int i = 0; i < manufacturedCode; i++) {
                        counter.setColor(Color.WHITE);
                        counter.draw();
                        code[i] = CodeFactory.getNewCode();
                        if (code[i] instanceof GoodCode) {
                            master[i] = MasterTypeFactory.getNewMaster2();
                            master[i].draw();
                        } else {
                            master[i] = MasterTypeFactory.getNewMaster();
                            master[i].draw();
                        }
                        code[i].move();
                        if (collision = colision(code[i], codeCadet)) {
                            colisionDetected(code[i]);
                        }
                        master[i].delete();
                    }
                }
            }
        }
    }

    public void colisionDetected(Code code) throws InterruptedException{
        if(code instanceof GoodCode) {
            week++;
            counter.setText(((Integer) week).toString());
            if(week==14){
                picWin.draw();
                gameover = true;
                restart = true;
                for(int i=0; i <manufacturedCode; i++){
                    this.master[i].delete();

                }

            }
        }

        if(code instanceof BadCode){
            picCoffee[manufacturedCoffee-1].delete();
            manufacturedCoffee--;
            if(manufacturedCoffee == 0){
                picLose.draw();
                gameover = true;
                restart = true;
                for(int i=0; i <manufacturedCode; i++){
                    this.master[i].delete();

                }


            }


        }

    }


    public boolean colision(Code code, Code cadet) throws InterruptedException {
        int codePosX = code.getPosX();
        int codePosY = code.getPosY();
        int cadetPosX = cadet.getPosX();
        int cadetPosY = cadet.getPosY();
        int codeBorderX = codePosX + 30;
        int codeBorderY = codePosY + 30;
        int cadetBorderX = cadetPosX + 60;
        if ((codeBorderY > cadetPosY || codePosY > cadetPosY)) {
            if(codePosX >= cadetPosX && codeBorderX <= cadetBorderX){
                return true;
            }
            return false;
        }
        return false;
    }




    public void startScreen() throws InterruptedException{
        Keyboard keyboard = new Keyboard(this);
        picStart = new Picture(PADDING, PADDING, "./resources/Splash.JPG");
        picStart.draw();

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

        KeyboardEvent one = new KeyboardEvent();
        one.setKey(KeyboardEvent.KEY_1);
        one.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(one);

        //start();

    }

    public void gameRestart() throws InterruptedException{

    }

    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                picStart.delete();
                continuar = true;
                break;
            case KeyboardEvent.KEY_1:
                picLose.delete();
                picWin.delete();
                gameover = false;
                picJava.delete();
                restart = false;
                break;
        }
    }

    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
        }

    }

}
