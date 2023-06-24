package Basic;

import java.util.Arrays;

public class MinMax {
    public static void main(String[] args) {
        int n = 100;
        double[] array = new double[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Min = " + min(array));
        System.out.println("Max = " + max(array));
        System.out.println("Average = " + average(array));

        System.out.println("\nMin = " + Arrays.stream(array).min());
        System.out.println("Max = " + Arrays.stream(array).max());
        System.out.println("Average = " + Arrays.stream(array).average());

    }

    public static double min (double[] array) {
        int minIndex = 0;
        double min = array[minIndex];
        for (int i = 1; i < array.length; i++) {
            if (array[minIndex] > array[i]) {
                min = array[i];
                minIndex = i;
            }
        }
        return min;
    }

    public static double max (double[] array) {
        int maxIndex = 0;
        double max = array[maxIndex];
        for (int i = 1; i < array.length; i++) {
            if (array[maxIndex] < array[i]) {
                max = array[i];
                maxIndex = i;
            }
        }
        return max;
    }

    public static double average (double[] array) {
        double sum = 0;
        int count = 0;
        for (double v : array) {
            sum += v;
            count++;
        }
        return sum / count;
    }
}
