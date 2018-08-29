package main.java.Test;

import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * @author: Rinchar
 * @date: 2018/8/28
 **/
public class Lambda {

    public static void main(String[] args) {
        BinaryOperator<Integer>  add = (x, y) -> x + y;
        add.apply(1, 2);
    }
}
