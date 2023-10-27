package search;

import java.util.Objects;

public class LinearSearch {
    private LinearSearch() {
    }

    /**
     * 线性查找
     *
     * @param arr    待查找数组
     * @param target 目标元素
     * @param <E>    数组元素类型
     * @return 目标元素在数组中的索引，没找到返回-1
     */
    public static <E> int search(E[] arr, E target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {84, 20, 6, 110, 2333, 7, 666, 5, 10};

        int res = LinearSearch.search(arr, 7);
        System.out.println(res);

        res = LinearSearch.search(arr, 100);
        System.out.println(res);

        String[] stringArr = {"hi", "hello", "hello world", "greet"};
        res = LinearSearch.search(stringArr, "hello");
        System.out.println(res);
    }
}
