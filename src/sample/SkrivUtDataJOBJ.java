package sample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class SkrivUtDataJOBJ {

    public void skrivUtDataJobj(Object hvaSomSkrives) throws FileNotFoundException {
        FileOutputStream foss =new FileOutputStream("JOBJArrangement.jobj",true);
        PrintWriter pww = new PrintWriter(foss);
        pww.println(hvaSomSkrives);
        pww.close();

    }



}
