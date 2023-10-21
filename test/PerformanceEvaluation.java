package test;

import search.LinearSearch;

/**
 * 算法性能评估
 */
public class PerformanceEvaluation {
    public static void evaluateLinearSearch() {
        int[] sizeArray = {1_000_000, 10_000_000};
        for (int n : sizeArray) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            int runTimes = 100;
            long beginTime = System.nanoTime();
            for (int i = 0; i < runTimes; i++) {
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();
            float costTime = (endTime - beginTime) / 1_000_000_000f;
            System.out.printf("array size: %d, cost: %f s%n", n, costTime);
        }
    }

    public static void main(String[] args) {
        PerformanceEvaluation.evaluateLinearSearch();
    }
}
