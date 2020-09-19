package spring_test.conf;

public class SempleClass {
    private static int counter = 0;
    private static int constructorCounter = 0;

    public SempleClass() {
        constructorCounter++;
    }

    public int getConstructorCounter() {
        return constructorCounter;
    }

    public int getCounter() {
        return counter++;
    }
}
