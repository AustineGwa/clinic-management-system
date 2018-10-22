package sample.fxcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Created by User on 10/12/2018.
 */
public class AdminController {

    @FXML private Button btnpatients;
    @FXML private Button btnmedicine;
    @FXML private Button btnemployees;
    @FXML private Pane patientpane;
    @FXML private Pane Medicinepane;
    @FXML private Pane Employeepane;

    @FXML
    public void switchPanes(ActionEvent event) {

        if (event.getSource() == btnpatients) {
            patientpane.toFront();

        } else if (event.getSource() == btnmedicine) {
            btnmedicine.toFront();

        } else if (event.getSource() == btnemployees) {
            btnemployees.toFront();


        }

    }

}
