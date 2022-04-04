package basic;

public class ThreadPractice {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("hello thread"));
    }
}
