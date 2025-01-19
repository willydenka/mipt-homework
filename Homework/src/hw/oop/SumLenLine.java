package hw.oop;

// 2.3.5
public abstract class SumLenLine {
    abstract double getLen();
}

interface Sum {
    static double getLen(SumLenLine sumLenLine) {
        return sumLenLine.getLen();
    }
}
