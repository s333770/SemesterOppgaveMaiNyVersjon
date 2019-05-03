package sample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class SkrivUtDataCSV extends SkrivData  {


    public void skrivDataTilCSVFil(Object hvaSomSkrives) throws FileNotFoundException {
        FileOutputStream fileOutputStream =new FileOutputStream("CSVArrangement.CSV",true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        printWriter.println(hvaSomSkrives);
        printWriter.close();
    }
}
