import java.util.Arrays;
import java.util.Iterator;

public class Singleton {

    private static Singleton single_instance = null;

    private int[] myArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Iterator<Integer> iterator = Arrays.stream(myArray).iterator();

    private Singleton() {}

    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }

    public synchronized void iterateTheArray() throws InterruptedException {
        while (iterator.hasNext()){
            try {
                Thread.sleep(500);
                System.out.println(iterator.next());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public int[] getMyArray() {
        return myArray;
    }
}