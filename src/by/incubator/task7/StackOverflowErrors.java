package by.incubator.task7;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StackOverflowErrors {
    public static void stackOverFlowMethod1() {
        StackOverflowErrors stackOverflowErrors = new StackOverflowErrors();
    }

    public static void stackOverFlowMethod2() {
        stackOverFlowMethod2();
    }

    public StackOverflowErrors() {
        StackOverflowErrors stackOverflowErrors = new StackOverflowErrors();
    }
}