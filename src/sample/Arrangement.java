package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Arrangement {
    private String arrangement;
    private String type;
    private String artister;
    private String lokale;
    private LocalDate dato;
    private String tidspunkt;
    private String bilettpris;
    private int bilettsalg;
    private String kontaktPerson;

    public static ObservableList<Arrangement> arrangementObservableList= FXCollections.observableArrayList();




    public Arrangement(String arrangement, String type, String artister, String lokale, LocalDate dato, String tidspunkt, String bilettpris, int bilettsalg, String kontaktPerson) {
        this.arrangement = arrangement;
        this.type = type;
        this.artister = artister;
        this.lokale = lokale;
        this.dato = dato;
        this.tidspunkt = tidspunkt;
        this.bilettpris = bilettpris;
        this.bilettsalg = bilettsalg;
        this.kontaktPerson = kontaktPerson;
    }


    public String getArrangement() {
        return arrangement;
    }

    public void setArrangement(String arrangement) {
        this.arrangement = arrangement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArtister() {
        return artister;
    }

    public void setArtister(String artister) {
        this.artister = artister;
    }

    public String getLokale() {
        return lokale;
    }

    public void setLokale(String lokale) {
        this.lokale = lokale;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public String getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(String tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public String getBilettpris() {
        return bilettpris;
    }

    public void setBilettpris(String bilettpris) {
        this.bilettpris = bilettpris;
    }

    public int getBilettsalg() {
        return bilettsalg;
    }

    public void setBilettsalg(int bilettsalg) {
        this.bilettsalg = bilettsalg;
    }

    public String getKontaktPerson() {
        return kontaktPerson;
    }

    public void setKontaktPerson(String kontaktPerson) {
        this.kontaktPerson = kontaktPerson;
    }

    @Override
    public String toString() {
        return "Arrangement{" +
                "arrangement='" + arrangement + '\'' +
                ", type='" + type + '\'' +
                ", artister='" + artister + '\'' +
                ", lokale='" + lokale + '\'' +
                ", dato=" + dato +
                ", tidspunkt='" + tidspunkt + '\'' +
                ", bilettpris='" + bilettpris + '\'' +
                ", bilettsalg='" + bilettsalg + '\'' +
                ", kontaktPerson='" + kontaktPerson + '\'' +
                '}';
    }
    /*
    public static void leggTilDataObservableList(String arrangement, String type, String artister, String lokale, LocalDate dato, String tidspunkt, String bilettpris, String bilettsalg, String kontaktPerson){
        arrangementObservableList.add(new Arrangement(arrangement,type,artister,lokale,dato,tidspunkt,bilettpris,bilettsalg,kontaktPerson));
    }
    */



}
