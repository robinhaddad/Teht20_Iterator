import java.util.ArrayList;
import java.util.Iterator;

public class AnotherThread extends Thread {
    ArrayList<String> stringsList = new ArrayList<>();
    public void run() {
        System.out.println("lisätään tämä lause paloissa listaan ja poistetaan kaikki sanat jotka ovat yli 6 kirjainta");
        stringsList.add("lisätään");
        stringsList.add("tämä");
        stringsList.add("lause");
        stringsList.add("paloissa");
        stringsList.add("listaan");
        stringsList.add("ja");
        stringsList.add("poistetaan");
        stringsList.add("kaikki");
        stringsList.add("sanat");
        stringsList.add("jotka");
        stringsList.add("ovat");
        stringsList.add("yli");
        stringsList.add("6");
        stringsList.add("kirjainta");
        for (Iterator<String> stringIterator = stringsList.iterator();stringIterator.hasNext();){
            String value = stringIterator.next();
            if (value.length()>6){
                stringIterator.remove();
                System.out.println("poistettu arvo:"+value);
            }
        }
    }
}
