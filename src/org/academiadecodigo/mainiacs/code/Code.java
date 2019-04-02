package org.academiadecodigo.mainiacs.code;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Code {

    private Code codeType;
    private Picture picture;


    public Code getCodeType() {
        return codeType;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setCodeType(Code codeType) {
        this.codeType = codeType;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public abstract void setSpeed();

    public abstract void move() throws InterruptedException;

    public abstract int getPosY();

    public abstract int getPosX();

}