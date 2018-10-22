package sample.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sample.database.DbConnection;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by User on 10/19/2018.
 */
public class ReportGenerator {



    public void generateWeeklyPatientReport(){


        try {
            Connection conn = DbConnection.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM patients");
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("patients report");
            XSSFRow row = spreadsheet.createRow(0);

            XSSFCell cell;
            cell = row.createCell(0);
            cell.setCellValue("Name");
            cell = row.createCell(1);
            cell.setCellValue("Registration Number");
            cell = row.createCell(2);
            cell.setCellValue("Year");
            cell = row.createCell(3);
            cell.setCellValue("symptoms");
            cell = row.createCell(4);
            cell.setCellValue("Disease");
            cell = row.createCell(5);
            cell.setCellValue("Prescription");


            int i = 1;


            while(rs.next()) {
                row = spreadsheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(rs.getString("name"));
                cell = row.createCell(1);
                cell.setCellValue(rs.getString("reg_num"));
                cell = row.createCell(2);
                cell.setCellValue(rs.getString("year"));
                cell = row.createCell(3);
                cell.setCellValue(rs.getString("symptoms"));
                cell = row.createCell(4);
                cell.setCellValue(rs.getString("disease"));
                cell = row.createCell(5);
                cell.setCellValue(rs.getString("prescription"));
                i++;
            }

            FileOutputStream out = new FileOutputStream(new File("patientsreport.xlsx"));
            workbook.write(out);
            out.close();
            JOptionPane.showMessageDialog(null,"exceldatabase.xlsx written successfully");


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void generateAllCurrentMedics(){
        try {
            Connection conn = DbConnection.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM doctors");
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Doctors report");
            XSSFRow row = spreadsheet.createRow(0);

            XSSFCell cell;
            cell = row.createCell(0);
            cell.setCellValue("Name");
            cell = row.createCell(1);
            cell.setCellValue("ID");
            cell = row.createCell(2);
            cell.setCellValue("Specialization");



            int i = 1;


            while(rs.next()) {
                row = spreadsheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(rs.getString("name"));
                cell = row.createCell(1);
                cell.setCellValue(rs.getString("ID"));
                cell = row.createCell(2);
                cell.setCellValue(rs.getString("specialization"));

                i++;
            }

            FileOutputStream out = new FileOutputStream(new File("doctorsreport.xlsx"));
            workbook.write(out);
            out.close();
            JOptionPane.showMessageDialog(null,"doctorsreport.xlsx written successfully");


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void generateDiseaseTrends(){
        JOptionPane.showMessageDialog(null,"disease report");

    }
}
