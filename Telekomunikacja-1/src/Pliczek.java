import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

public class Pliczek {

    public byte[] readFile(String pathFile) {
        byte[] evr;
        String error;

        File file = new File(pathFile);
        byte[] fileByte = new byte[(int) file.length()];
        FileInputStream inFile;

        try {
            inFile = new FileInputStream(file);
            inFile.read(fileByte);

        } catch (FileNotFoundException var5) {
            error = "Błąd";
            evr = error.getBytes();
            return evr;
        } catch (IOException var6) {
            error = "Zła ścieżka";
            evr = error.getBytes();
            return evr;
        }
        return fileByte;
    }

    public void writeFile(String pathFile, String wiadomosc) throws IOException {
        //Path path = Paths.get(pathFile);
        //Files.write(path, wiadomosc);

        PrintWriter out = new PrintWriter(pathFile);
        out.println(wiadomosc);
    }
}
