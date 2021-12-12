import java.util.Arrays;
import java.util.Iterator;

public class Helper implements Runnable {

    private Iterator<Integer> it;

    @Override
    public void run() {
        it = Arrays.stream(Singleton.getInstance().getMyArray()).iterator();
        while (it.hasNext()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "," +  it.next());
        }
    }
}
