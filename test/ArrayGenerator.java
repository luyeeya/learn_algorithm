package test;

import java.util.Random;

public class ArrayGenerator {
    /**
     * 生成一个有序数组
     *
     * @param n 数组长度
     * @return 生成的有序数组
     */
    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 生成一个随机数组
     *
     * @param n     数组长度
     * @param bound 随机数范围：[0, bound)
     * @return 生成的随机数组
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
