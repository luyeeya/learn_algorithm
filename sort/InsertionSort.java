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
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                E temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    /**
     * 插入排序（优化：部分交换变为右移）
     *
     * @param arr 待排序数组
     * @param <E> 数组元素类型
     */
    public static <E extends Comparable<E>> void sort_optimized(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 循环不变量：arr[0, i)有序，arr[i, arr.length)无序
        for (int i = 1; i < arr.length; i++) {
            E target = arr[i];
            int j;
            for (j = i; j > 0 && target.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = target;
        }
    }
}
