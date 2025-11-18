package gpa.controller;

import gpa.model.Course;
import gpa.model.CourseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GPAResultController {

    @FXML
    private TableView<Course> table;

    @FXML
    private TableColumn<Course, String> courseNameColumn;
    @FXML
    private TableColumn<Course, String> courseCodeColumn;
    @FXML
    private TableColumn<Course, Double> creditColumn;
    @FXML
    private TableColumn<Course, String> teacher1Column;
    @FXML
    private TableColumn<Course, String> teacher2Column;
    @FXML
    private TableColumn<Course, String> gradeColumn;

    @FXML
    private Label finalGPA;

    // This method initializes the TableView and GPA when the scene is loaded
    @FXML
    public void initialize() {
        // Set up columns
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseCodeColumn.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        creditColumn.setCellValueFactory(new PropertyValueFactory<>("credit"));
        teacher1Column.setCellValueFactory(new PropertyValueFactory<>("teacher1"));
        teacher2Column.setCellValueFactory(new PropertyValueFactory<>("teacher2"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        // Load courses from CourseManager
        ObservableList<Course> courseList = FXCollections.observableArrayList(
                CourseManager.getInstance().getCourses()
        );
        table.setItems(courseList);

        // Calculate and display final GPA
        double gpa = CourseManager.getInstance().calculateGPA();
        finalGPA.setText("Final GPA: " + String.format("%.2f", gpa));
    }
}
