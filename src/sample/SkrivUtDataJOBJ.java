package sample;

import java.io.*;

public class SkrivUtDataJOBJ extends SkrivData implements Serializable {


    public SkrivUtDataJOBJ(ArrangementKontakpersonSamlet skrivUt, File filType) {

    }

    public void skrivUtDataJobj(Object hvaSomSkrives, String filvei) throws FileNotFoundException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filvei);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hvaSomSkrives);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



}
