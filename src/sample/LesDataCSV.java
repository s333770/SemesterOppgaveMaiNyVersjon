package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LesDataCSV extends LesData {

    public void lesDataCSV() throws IOException {


        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "\\C:\\Users\\Andreas\\Desktop\\text.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // leser neste linje
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
