package sample.models;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by charloh on 10/17/2018.
 */
public class Patient {
    private StringProperty name;
    private StringProperty regNum;
    private StringProperty year;
    private StringProperty symptoms;
    private StringProperty disease;
    private StringProperty prescription;

    public Patient() {
    }

    public Patient(String name, String regNum, String year, String symptoms, String disease, String prescription) {
        this.name = new SimpleStringProperty(name);
        this.regNum = new SimpleStringProperty(regNum);
        this.year = new SimpleStringProperty(year);
        this.symptoms = new SimpleStringProperty(symptoms);
        this.disease =new SimpleStringProperty(disease);
        this.prescription =new SimpleStringProperty( prescription);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getRegNum() {
        return regNum.get();
    }

    public StringProperty regNumProperty() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum.set(regNum);
    }

    public String getYear() {
        return year.get();
    }

    public StringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getSymptoms() {
        return symptoms.get();
    }

    public StringProperty symptomsProperty() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms.set(symptoms);
    }

    public String getDisease() {
        return disease.get();
    }

    public StringProperty diseaseProperty() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease.set(disease);
    }

    public String getPrescription() {
        return prescription.get();
    }

    public StringProperty prescriptionProperty() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription.set(prescription);
    }
}
