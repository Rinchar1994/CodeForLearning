package main.java.Test.AbstractFactory;

/**
 * @author: Rinchar
 * @date: 2018/8/25
 **/
public class UglyS implements AbstractFactory {

    public UglyS() {
        System.out.println("UglyS");
    }

    @Override
    public Card createCard() {
        return new CardPaodekuai();
    }

    @Override
    public Majong createMajong() {
        return new MajongShanghai();
    }
}
