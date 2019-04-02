package org.academiadecodigo.mainiacs.master;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MasterTypeFactory {



    public static Picture getNewMaster() {
        int posX = 10;
        int posY = 400;

        int random = (int) (Math.random() * MasterType.values().length);
        MasterType codeType = MasterType.values()[random];

        Picture master = null;

        switch (codeType) {
            case PEDRO:
                master = new Picture(posX, posY,"./resources/notcoolB.jpg");
                break;
            case SORARIA:
                master = new Picture(posX, posY,"./resources/notcoolS.jpg");
                break;
            case ROBIN:
                master = new Picture(posX, posY,"./resources/notcoolR.jpg");
                break;
            case PEDRO2:
                master = new Picture(posX, posY,"./resources/goodB.jpg");
                break;
            case SORARIA2:
                master = new Picture(posX, posY,"./resources/notcoolS.jpg");
                break;
            case ROBIN2:
                master = new Picture(posX, posY,"./resources/goodB.jpg");
                break;
        }

        return master;

    }

    public static Picture getNewMaster2() {

        int posXX = 10;
        int posYY = 400;
        int random = (int) (Math.random() * MasterType.values().length);
        MasterType codeType = MasterType.values()[random];

        Picture master = null;

        switch (codeType) {
            case PEDRO:
                master = new Picture(posXX, posYY,"./resources/awesomeB.jpg");
                break;
            case SORARIA:
                master = new Picture(posXX, posYY,"./resources/awesomeS.jpg");
                break;
            case ROBIN:
                master = new Picture(posXX, posYY,"./resources/awesomeR.jpg");
                break;
            case PEDRO2:
                master = new Picture(posXX, posYY,"./resources/awesomeB.jpg");
                break;
            case SORARIA2:
                master = new Picture(posXX, posYY,"./resources/goodS.jpg");
                break;
            case ROBIN2:
                master = new Picture(posXX, posYY,"./resources/awesomeR.jpg");
                break;
        }

        return master;

    }


}
