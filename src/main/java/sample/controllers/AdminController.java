package sample.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.database.DbConnection;
import sample.models.Doctor;
import sample.models.Patient;
import sample.utils.ReportGenerator;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    private DbConnection dc;
    private ObservableList<Patient> patients;
    private ObservableList<Doctor>  doctors;
    ReportGenerator reportGenerator = new ReportGenerator();

   @FXML private TextField studentName;
   @FXML private TextField studentRegNum;
   @FXML private TextField studentYear;
   @FXML private TextArea  studentSymptoms;
   @FXML private TextField possibleDisease;
   @FXML private TextArea  diseasePrescription;
   @FXML private TextField doctorName;
   @FXML private TextField doctorId;
   @FXML private TextField doctorSpecialization;

   //patient table details.
    @FXML TableView<Patient> patientsTable;
    @FXML TableColumn<Patient, String> nameColumn;
    @FXML TableColumn<Patient, String> regNumColumn;
    @FXML TableColumn<Patient, String> yearColumn;
    @FXML TableColumn<Patient, String> symptomsColumn;
    @FXML TableColumn<Patient, String> diseaseColumn;
    @FXML TableColumn<Patient, String> prescriptionColumn;

    //Doctors table details

    @FXML TableView<Doctor> doctorsTable;
    @FXML TableColumn<Doctor, String> doctorNameColumn;
    @FXML TableColumn<Doctor, String> doctorIdColumn;
    @FXML TableColumn<Doctor, String> doctorSpecializationColumn;




   @FXML
    public  void onSubmitPatientButtonClicked(ActionEvent event){

       persistPatientTodb();
       refreshPatientTable();
   }

   public void onSubmitDoctorButtonClicked(){
        persistDoctorToDb();
        refreshDoctorsTable();

   }

   @FXML
   public void onWeeklyPatientsButtonClicked(){
       reportGenerator.generateWeeklyPatientReport();

   }

    @FXML
    public void onCurrentMedicsButtonClicked(){
       reportGenerator.generateAllCurrentMedics();

    }

    @FXML
    public void onDiseaseTrendsButtonClicked(){
        reportGenerator.generateDiseaseTrends();

    }


   @FXML
    public void refreshPatientTable() {

        try {
            Connection conn = DbConnection.getConnection();
            this.patients = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM patients");
            while (rs.next()) {

                Patient patient = new Patient(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                this.patients.add(patient);
            }
        }
        catch (SQLException e) {
            System.err.println("Error " + e);
        }

        this.nameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
        this.regNumColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("regNum"));
        this.yearColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("year"));
        this.symptomsColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("symptoms"));
        this.diseaseColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("disease"));
        this.prescriptionColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("prescription"));

        this.patientsTable.setItems(null);
        this.patientsTable.setItems(patients);
    }

    public void refreshDoctorsTable(){

        try {
            Connection conn = DbConnection.getConnection();
            this.doctors = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM doctors");
            while (rs.next()) {


                Doctor doctor = new Doctor(rs.getString(1), rs.getString(2), rs.getString(3));
                this.doctors.add(doctor);
            }
        }
        catch (SQLException e) {
            System.err.println("Error " + e);
        }

        this.doctorNameColumn.setCellValueFactory(new PropertyValueFactory<Doctor, String>("name"));
        this.doctorIdColumn.setCellValueFactory(new PropertyValueFactory<Doctor, String>("ID"));
        this.doctorSpecializationColumn.setCellValueFactory(new PropertyValueFactory<Doctor, String>("specialization"));


        this.doctorsTable.setItems(null);
        this.doctorsTable.setItems(doctors);

    }

    @FXML
    private void persistPatientTodb() {
        String sql = "INSERT INTO `patients`(`name`, `reg_num`, `year`, `symptoms`, `disease`,`prescription`) VALUES (? , ?, ?, ?, ?,?)";
        try
        {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.studentName.getText());
            stmt.setString(2, this.studentRegNum.getText());
            stmt.setString(3, this.studentYear.getText());
            stmt.setString(4, this.studentSymptoms.getText());
            stmt.setString(5, this.possibleDisease.getText());
            stmt.setString(6, this.diseasePrescription.getText());
           

            stmt.execute();
            conn.close();
            System.out.println("executed " );

        }
        catch (SQLException e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    private void persistDoctorToDb(){

        String sql = "INSERT INTO `doctors`(`name`, `ID`, `specialization`) VALUES(?,?,?)";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, this.doctorName.getText());
            stmt.setString(2, this.doctorId.getText());
            stmt.setString(3, this.doctorSpecialization.getText());

            stmt.execute();
            conn.close();
            System.out.println("executed " );
        } catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.dc = new DbConnection();


    }
}
