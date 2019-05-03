package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

public abstract class LesData implements Serializable,Runnable {
    public LesData(Object objekt){

    }
    public LesData(){

    }

    public abstract void lesData(Scanner input) throws FileNotFoundException;

    public static String getFileExtension(String fullName) {
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
    @Override
    public void run(){

    }

}
