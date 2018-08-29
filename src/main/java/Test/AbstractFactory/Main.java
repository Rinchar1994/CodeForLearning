package main.java.Test.AbstractFactory;

import main.java.Test.AbstractFactory.*;

/**
 * @author: Rinchar
 * @date: 2018/8/25
 **/
public class Main {
    public static void main(String[] args) {
        AbstractFactory handsomeJ = new HandsomeJ();
        AbstractFactory uglyS = new UglyS();

        Card cardJ = handsomeJ.createCard();
        Majong majongJ = handsomeJ.createMajong();
        cardJ.playCard();
        majongJ.playMajong();

        Card cardS = uglyS.createCard();
        Majong majongS = uglyS.createMajong();
        cardS.playCard();
        majongS.playMajong();
    }
}
