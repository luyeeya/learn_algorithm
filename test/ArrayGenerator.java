package test;

public class ArrayGenerator {
    public static Integer[] generateOrderedArray(int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
        return data;
    }
}
