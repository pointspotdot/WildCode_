package org.academiadecodigo.mainiacs.code;

public class CodeFactory {

    public static Code getNewCode() {

        int random = (int) (Math.random() * CodeType.values().length);
        CodeType codeType = CodeType.values()[random];

        Code code = null;

        switch (codeType) {
            case GOOD_CODE:
                code = new GoodCode();
                break;
            case BAD_CODE:
                code = new BadCode();
                break;
        }

        return code;

    }

}