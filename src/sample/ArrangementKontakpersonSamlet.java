package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class ArrangementKontakpersonSamlet {
    public static ObservableList <ArrangementKontakpersonSamlet> arrangementKontaktpersonSamletObservableList= FXCollections.observableArrayList();

    private SimpleStringProperty typeSamlet;
    private SimpleStringProperty artisterSamlet;
    private SimpleStringProperty lokaleSamlet;
    private LocalDate datoSamlet;
    private SimpleStringProperty tidspunktSamlet;
    private SimpleStringProperty bilettprisSamlet;
    private SimpleIntegerProperty bilettsalgSamlet;

    private SimpleStringProperty kontaktPersonSamlet;
    private SimpleStringProperty personNummerSamlet;
    private SimpleStringProperty personEmailSamlet;
    private SimpleStringProperty personSideSamlet;
    private SimpleStringProperty personFirmaSamlet;
    private SimpleStringProperty personTekstSamlet;

    public ArrangementKontakpersonSamlet(String arrangementSamlet, String typeSamlet, String artisterSamlet, String lokaleSamlet, LocalDate datoSamlet, String tidspunktSamlet, String bilettprisSamlet, Integer bilettsalgSamlet, String kontaktPersonSamlet, String personNummerSamlet, String personEmailSamlet, String personSideSamlet, String personFirmaSamlet, String personTekstSamlet) {
        this.arrangementSamlet =new SimpleStringProperty(arrangementSamlet);
        this.typeSamlet = new SimpleStringProperty(typeSamlet);
        this.artisterSamlet =new SimpleStringProperty( artisterSamlet);
        this.lokaleSamlet = new SimpleStringProperty(lokaleSamlet);
        this.datoSamlet = datoSamlet;
        this.tidspunktSamlet =new SimpleStringProperty( tidspunktSamlet);
        this.bilettprisSamlet = new SimpleStringProperty(bilettprisSamlet);
        this.bilettsalgSamlet = new SimpleIntegerProperty(bilettsalgSamlet);
        this.kontaktPersonSamlet =new SimpleStringProperty(kontaktPersonSamlet);
        this.personNummerSamlet = new SimpleStringProperty(personNummerSamlet);
        this.personEmailSamlet = new SimpleStringProperty(personEmailSamlet);
        this.personSideSamlet = new SimpleStringProperty(personSideSamlet);
        this.personFirmaSamlet = new SimpleStringProperty(personFirmaSamlet);
        this.personTekstSamlet = new SimpleStringProperty(personTekstSamlet);
    }

    private SimpleStringProperty arrangementSamlet;

    @Override
    public String toString() {
        return "ArrangementKontakpersonSamlet{" +
                "arrangementSamlet=" + arrangementSamlet +
                ", typeSamlet=" + typeSamlet +
                ", artisterSamlet=" + artisterSamlet +
                ", lokaleSamlet=" + lokaleSamlet +
                ", datoSamlet=" + datoSamlet +
                ", tidspunktSamlet=" + tidspunktSamlet +
                ", bilettprisSamlet=" + bilettprisSamlet +
                ", bilettsalgSamlet=" + bilettsalgSamlet +
                ", kontaktPersonSamlet=" + kontaktPersonSamlet +
                ", personNummerSamlet=" + personNummerSamlet +
                ", personEmailSamlet=" + personEmailSamlet +
                ", personSideSamlet=" + personSideSamlet +
                ", personFirmaSamlet=" + personFirmaSamlet +
                ", personTekstSamlet=" + personTekstSamlet +
                '}';
    }



    public SimpleStringProperty getArrangementSamlet() {
        return arrangementSamlet;
    }

    public SimpleStringProperty arrangementSamletProperty() {
        return arrangementSamlet;
    }

    public void setArrangementSamlet(String arrangementSamlet) {
        this.arrangementSamlet.set(arrangementSamlet);
    }

    public SimpleStringProperty getTypeSamlet() {
        return typeSamlet;
    }

    public SimpleStringProperty typeSamletProperty() {
        return typeSamlet;
    }

    public void setTypeSamlet(String typeSamlet) {
        this.typeSamlet.set(typeSamlet);
    }

    public String getArtisterSamlet() {
        return artisterSamlet.get();
    }

    public SimpleStringProperty artisterSamletProperty() {
        return artisterSamlet;
    }

    public void setArtisterSamlet(String artisterSamlet) {
        this.artisterSamlet.set(artisterSamlet);
    }

    public SimpleStringProperty getLokaleSamlet() {
        return lokaleSamlet;
    }

    public SimpleStringProperty lokaleSamletProperty() {
        return lokaleSamlet;
    }

    public void setLokaleSamlet(String lokaleSamlet) {
        this.lokaleSamlet.set(lokaleSamlet);
    }

    public LocalDate getDatoSamlet() {
        return datoSamlet;
    }

    public void setDatoSamlet(LocalDate datoSamlet) {
        this.datoSamlet = datoSamlet;
    }

    public SimpleStringProperty getTidspunktSamlet() {
        return tidspunktSamlet;
    }

    public SimpleStringProperty tidspunktSamletProperty() {
        return tidspunktSamlet;
    }

    public void setTidspunktSamlet(String tidspunktSamlet) {
        this.tidspunktSamlet.set(tidspunktSamlet);
    }

    public SimpleStringProperty getBilettprisSamlet() {
        return bilettprisSamlet;
    }

    public SimpleStringProperty bilettprisSamletProperty() {
        return bilettprisSamlet;
    }

    public void setBilettprisSamlet(String bilettprisSamlet) {
        this.bilettprisSamlet.set(bilettprisSamlet);
    }

    public SimpleIntegerProperty getBilettsalgSamlet() {
        return bilettsalgSamlet;
    }

    public SimpleIntegerProperty bilettsalgSamletProperty() {
        return bilettsalgSamlet;
    }

    public void setBilettsalgSamlet(int bilettsalgSamlet) {
        this.bilettsalgSamlet.set(bilettsalgSamlet);
    }

    public SimpleStringProperty getKontaktPersonSamlet() {
        return kontaktPersonSamlet;
    }

    public SimpleStringProperty kontaktPersonSamletProperty() {
        return kontaktPersonSamlet;
    }

    public void setKontaktPersonSamlet(String kontaktPersonSamlet) {
        this.kontaktPersonSamlet.set(kontaktPersonSamlet);
    }

    public String getPersonNummerSamlet() {
        return personNummerSamlet.get();
    }

    public SimpleStringProperty personNummerSamletProperty() {
        return personNummerSamlet;
    }

    public void setPersonNummerSamlet(String personNummerSamlet) {
        this.personNummerSamlet.set(personNummerSamlet);
    }

    public String getPersonEmailSamlet() {
        return personEmailSamlet.get();
    }

    public SimpleStringProperty personEmailSamletProperty() {
        return personEmailSamlet;
    }

    public void setPersonEmailSamlet(String personEmailSamlet) {
        this.personEmailSamlet.set(personEmailSamlet);
    }

    public String getPersonSideSamlet() {
        return personSideSamlet.get();
    }

    public SimpleStringProperty personSideSamletProperty() {
        return personSideSamlet;
    }

    public void setPersonSideSamlet(String personSideSamlet) {
        this.personSideSamlet.set(personSideSamlet);
    }

    public String getPersonFirmaSamlet() {
        return personFirmaSamlet.get();
    }

    public SimpleStringProperty personFirmaSamletProperty() {
        return personFirmaSamlet;
    }

    public void setPersonFirmaSamlet(String personFirmaSamlet) {
        this.personFirmaSamlet.set(personFirmaSamlet);
    }

    public String getPersonTekstSamlet() {
        return personTekstSamlet.get();
    }

    public SimpleStringProperty personTekstSamletProperty() {
        return personTekstSamlet;
    }

    public void setPersonTekstSamlet(String personTekstSamlet) {
        this.personTekstSamlet.set(personTekstSamlet);
    }





    }


