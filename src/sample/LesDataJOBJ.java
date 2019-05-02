package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class LesDataJOBJ extends LesData {
    public LesDataJOBJ(Scanner input) {
        try {
            this.lesData(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void lesData(Scanner input) throws FileNotFoundException {
       /* public Object LesObjektFraFil(String filepath)
            try {

                FileInputStream fileIn = new FileInputStream(filepath);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                Object obj = objectIn.readObject();

                System.out.println("The Object has been read from the file");
                objectIn.close();
                return obj;

            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
            */
        }

    }

