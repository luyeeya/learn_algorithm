package sort;

import java.util.Arrays;

public class SelectionSort {
    private SelectionSort() {
    }

    /**
     * 选择排序（原地排序，不使用辅助空间）
     *
     * @param arr 待排序数组
     * @param <E> 数组元素类型
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 循环不变量：arr[0, i) 是有序的，arr[i, arr.length) 是无序的
        for (int i = 0; i < arr.length - 1; i++) {
            // 找到 [i, arr.length) 区间中最小值的索引
            int minIdx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            // 交换索引 minIdx 和索引 i 位置上的值，即最小值前移到了索引 i 处
            E temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    static class Student implements Comparable<Student> {
        private final String name;
        private final int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        /**
         * 按照成绩由低到高排序
         *
         * @param another 要比较的学生
         * @return 比较结果, 负值表示小于, 正值表示大于
         */
        @Override
        public int compareTo(Student another) {
            return this.score - another.score;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', score=" + score + '}';
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {57, 2333, 100, 666, 9527, 999, 95, 88, 827};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        Student[] studentArr = {
                new Student("zhangsan", 100),
                new Student("lisi", 59),
                new Student("wangwu", 88),
                new Student("zhaoliu", 60),
                new Student("tianqi", 79),
        };
        SelectionSort.sort(studentArr);
        System.out.println(Arrays.toString(studentArr));
    }
}
