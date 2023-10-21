package search;

import java.util.Objects;

/**
 * 线性查找法
 */
public class LinearSearch {
    public static <T> int search(T[] data, T target) {
        for (int i = 0; i < data.length; i++) {
            if (Objects.equals(data[i], target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] data = {84, 20, 6, 110, 2333, 7, 666, 5, 10};

        int res = LinearSearch.search(data, 7);
        System.out.println(res);

        res = LinearSearch.search(data, 100);
        System.out.println(res);

        String[] stringData = {"hi", "hello", "hello world", "greet"};
        res = LinearSearch.search(stringData, "hello");
        System.out.println(res);
    }
}
