package Task5;

public class Main {
    public static void bar() {
        try {
            throw new ClassCastException();
        } catch (RuntimeException e) {
            if (!(e instanceof ClassCastException)) {
                System.out.println("fail");
            }
        }
    }
    public static void main(String[] args) {
        bar();
    }
}
