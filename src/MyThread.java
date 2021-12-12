public class MyThread extends Thread {
    public void run(){
        try {
            Singleton.getInstance().iterateTheArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
