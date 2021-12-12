import java.util.Arrays;
import java.util.Iterator;

public class Main implements Runnable {

    private String[] stringArray = new String[]{"Kuinka","käy,","jos","kokoelmaan","tehdään","muutoksia","iteroinnin","läpikäynnin","aikana."};
    private String[] anotherStringArray = new String[]{"Varmaan","aika,","huonosti","voisin","äkkiseltään","kuvitella","että","tulee","käymään."};
    private Iterator<String> stringIterator = Arrays.stream(stringArray).iterator();

    public static void main(String[] args) {

        System.out.println("a) Tutki kuinka Javan iteraattori käyttäytyy, " +
                "jos yritetään iteroida kokoelmaa kahdella säikeellä yhtä aikaa, kun molemmilla on oma iterattori.");
        Helper helper = new Helper();
        Helper helper1 = new Helper();

        Thread helperThread = new Thread(helper, "thread #1");
        Thread helperThread1 = new Thread(helper1, "thread #2");

        helperThread.start();
        helperThread1.start();

        try{
            helperThread.join();
            helperThread1.join();

            System.out.println("b) entä, jos säikeet käyttävät samaa iteraattoria vuorotellen?");
            MyThread myThread = new MyThread();
            MyThread myThread1 = new MyThread();

            myThread.start();
            myThread1.start();

            try {
                myThread.join();
                myThread1.join();

                System.out.println("c) Kuinka käy, jos kokoelmaan tehdään muutoksia iteroinnin läpikäynnin aikana.");
                Main mainObj = new Main();
                Thread mainObjThread = new Thread(mainObj);
                mainObjThread.start();
                mainObj.changeItUp();

                try {
                    mainObjThread.join();

                    System.out.println("d) Keksi jotain muuta testattavaa (esim. iteraattorin remove).");
                    AnotherThread anotherThread = new AnotherThread();
                    anotherThread.start();

                } catch (Exception e){
                    System.out.println(e);
                }

            } catch (Exception e) {
                System.out.println(e);
            }

            }catch (Exception e){
                System.out.println(e);
            }
        }

    public void changeItUp() throws InterruptedException {
        for(int i=0;i<stringArray.length;i++){
            stringArray[i] = anotherStringArray[i];
            Thread.sleep(500);
        }
    }

    @Override
    public void run() {
        while (stringIterator.hasNext()){
            try{
                System.out.println(stringIterator.next());
                Thread.sleep(500);
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
