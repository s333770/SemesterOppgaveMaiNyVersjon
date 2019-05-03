package sample;

import java.io.*;

public class SkrivUtDataJOBJ extends SkrivData {


    public SkrivUtDataJOBJ(ArrangementKontakpersonSamlet skrivUt, File filType) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filType);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(skrivUt);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void skrivUtDataJobj(Object hvaSomSkrives, String filvei) throws FileNotFoundException {


    }



}
