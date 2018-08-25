package main.java.Test.AbstractFactory;

/**
 * @author: Rinchar
 * @date: 2018/8/25
 **/
public class HandsomeJ implements AbstractFactory {

    public HandsomeJ() {
        System.out.println("HandsomeJ");
    }

    @Override
    public Card createCard() {
        return new CardDoudizhu();
    }

    @Override
    public Majong createMajong() {
        return new MajongHangzhou();
    }
}
