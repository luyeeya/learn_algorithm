package test;

public class Student implements Comparable<Student> {
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
