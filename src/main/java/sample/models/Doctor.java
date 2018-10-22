package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by User on 10/18/2018.
 */
public class Doctor {
    StringProperty name;
    StringProperty ID;
    StringProperty specialization;

    public Doctor() {
    }

    public Doctor(String name, String ID, String specialization){

        this.name = new SimpleStringProperty(name);
        this.ID = new SimpleStringProperty(ID);
        this.specialization = new SimpleStringProperty(specialization);
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

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getSpecialization() {
        return specialization.get();
    }

    public StringProperty specializationProperty() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization.set(specialization);
    }
}
