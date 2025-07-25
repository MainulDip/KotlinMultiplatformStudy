import org.junit.jupiter.api.Test;

public class TestMyClass {
    @Test
    public void testMyClass() {
        String[] arr = {"arg1", "arg2"};
        MyClass.main(arr);
        MyClass.main(new String[]{"arg1", "arg2"});
        System.out.println("Hello");
    }
}