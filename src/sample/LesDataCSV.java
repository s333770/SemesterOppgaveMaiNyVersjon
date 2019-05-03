package sample;

import javafx.stage.FileChooser;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static sample.ArrangementKontakpersonSamlet.arrangementKontaktpersonSamletObservableList;

public class LesDataCSV extends LesData {

    public LesDataCSV(Scanner input) {
        super();
        this.lesData(input);
    }

    public void lesData(Scanner input)  {
        String[] verdier = new String[0];
        while (input.hasNext()) {
            String word = input.next();
            verdier = word.split(",");
            System.out.println(verdier[0]);
        }
        for (int i = 0; i < verdier.length; i++) {
            System.out.println(verdier[i]);
        }
        try{
            if(verdier.length != 14){
                throw new InputException("Det er feil lengde på arrayen, den må ha 14 elementer");
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            arrangementKontaktpersonSamletObservableList.add(new ArrangementKontakpersonSamlet(verdier[0], verdier[1], verdier[2], verdier[3], LocalDate.parse(verdier[4],formatter), verdier[5], Integer.parseInt(verdier[6]), Integer.parseInt(verdier[7]), verdier[8], verdier[9], verdier[10], verdier[11], verdier[12], verdier[13]));

        }
        catch(InputException e) {
            System.err.println(e.getMessage());

        }
        catch(NumberFormatException e){
            System.err.println("BilettPris og antall biletter må leses inn som integer");
        }


    }

}
