package sort;

public class InsertionSort {
    private InsertionSort() {
    }

    /**
     * 插入排序
     *
     * @param arr 待排序数组
     * @param <E> 数组元素类型
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 循环不变量：arr[0, i)有序，arr[i, arr.length)无序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    E temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
