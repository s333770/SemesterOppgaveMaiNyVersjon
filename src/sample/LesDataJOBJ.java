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

        }

    }

