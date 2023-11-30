package test;

import sort.InsertionSort;
import sort.SelectionSort;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SortingHelper {
    /**
     * 判断数组是否升序排序
     *
     * @param arr 数组
     * @param <E> 数组元素泛型
     * @return true-数组有序，false-数组无序
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        if (arr == null) {
            return false;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 排序测试
     *
     * @param sortClass 排序算法类的 class 对象
     * @param arr       待排序数组
     * @param <E>       数组元素泛型
     */
    public static <E extends Comparable<E>> void sortTest(Class<?> sortClass, E[] arr) {
        long beginTime = System.nanoTime();
        try {
            Method[] methods = sortClass.getMethods();
            outer:
            for (Method method : methods) {
                if (method.getName().equals("sort")) {
                    for (Class<?> parameterType : method.getParameterTypes()) {
                        if (parameterType.equals(Comparable[].class)) {
                            method.invoke(null, (Object) arr);
                            if (!SortingHelper.isSorted(arr)) {
                                throw new RuntimeException(String.format("%s failed", sortClass.getSimpleName()));
                            }
                            break outer;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long endTime = System.nanoTime();
        double costTime = (endTime - beginTime) / 1000_000_000.0;
        System.out.printf("%s, length: %d, cost: %f s%n", sortClass.getSimpleName(), arr.length, costTime);
        if (arr.length <= 10) {
            System.out.printf("sorted array: %s%n", Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        Student[] studentArr = {
                new Student("zhangsan", 100),
                new Student("lisi", 59),
                new Student("wangwu", 88),
                new Student("zhaoliu", 60),
                new Student("tianqi", 79),
        };

        System.out.println("************************ SelectionSort ************************");
        SortingHelper.sortTest(SelectionSort.class, ArrayGenerator.generateRandomArray(10000, 100000));
        SortingHelper.sortTest(SelectionSort.class, studentArr.clone());

        System.out.println("************************ InsertionSort ************************");
        SortingHelper.sortTest(InsertionSort.class, ArrayGenerator.generateRandomArray(10000, 100000));
        SortingHelper.sortTest(InsertionSort.class, studentArr.clone());
    }
}
