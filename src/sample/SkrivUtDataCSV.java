package sample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class SkrivUtDataCSV extends SkrivData {


    public void skrivDataTilCSVFil(Object hvaSomSkrives) throws FileNotFoundException {
        FileOutputStream fos =new FileOutputStream("CSVArrangement.CSV",true);
        PrintWriter pw = new PrintWriter(fos);
        pw.println(hvaSomSkrives);
        pw.close();
    }
}
