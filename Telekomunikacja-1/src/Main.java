import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

public class Main {

    public static void main(String args[]) {
        Kodowanie kodowanie = new Kodowanie();

        Pliczek pliczek = new Pliczek();
        byte[] tab = pliczek.readFile("C:\\Users\\Adam\\Desktop\\dane.txt");
        int[] msg = new int[8];
        Vector<int[]> vector = new Vector();
        String string;

        for (int i = 0; i < tab.length; i++) {
            int[] pom;
            for (int j = 0, k = 128; j < 8; j++, k /= 2) {
                if ((k & tab[i]) != 0) {
                    msg[j] = 1;
                } else msg[j] = 0;
            }
            pom = kodowanie.koduj(msg);
            string = Arrays.toString(pom);
            try {
                pliczek.writeFile("C:\\Users\\Adam\\Desktop\\dane1.txt", string);
            } catch (IOException el) {
                el.printStackTrace();
            }
        }
    }
}
