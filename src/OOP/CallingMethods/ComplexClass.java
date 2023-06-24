package OOP.CallingMethods;

public class ComplexClass {
    public static void main(String[] args) {
        double a = 5.25;
        int b = 10;
        long c = 25;
        float d = 12.34f;

        mixedMethod((int) d, b, c);
        modifiedMethod(b, (float) a);
        mixedMethod(b, a, c);
        modifiedMethod(c, d);
        mixedMethod((int) c, a, b);
        modifiedMethod((long) a, d);
    }

    public static void mixedMethod(int num1, double num2, long num3) {
        System.out.println("Int: " + num1 + ", Double: " + num2 + ", Long: " + num3);
    }

    public static void modifiedMethod(long num1, float num2) {
        System.out.println("Long: " + num1 + ", Float: " + num2);
    }
}
