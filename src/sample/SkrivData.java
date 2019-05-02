package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public abstract class SkrivData {

    FileOutputStream fos;
    {
        try {
            fos = new FileOutputStream("CSVArrangement.CSV",true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    PrintWriter pw = new PrintWriter(fos);

    public static String getFileExtension(String fullName) {
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    public void skrivDataTilCSVFil(Object hvaSomSkrives) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("", true);
        PrintWriter pw = new PrintWriter(fos);
        pw.println(hvaSomSkrives);
        pw.close();

    }
}

