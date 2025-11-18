package gpa.controller;

import gpa.model.Course;
import gpa.model.CourseManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CourseEntryController {

    @FXML private TextField courseName, courseCode, courseCredit, teacher1, teacher2;
    @FXML private ComboBox<String> grade;
    @FXML private Button calcBtn;

    @FXML
    public void addCourse() {

        if (courseName.getText().isEmpty() ||
                courseCode.getText().isEmpty() ||
                courseCredit.getText().isEmpty() ||
                teacher1.getText().isEmpty() ||
                teacher2.getText().isEmpty() ||
                grade.getValue() == null) {

            show("Fill all fields!");
            return;
        }

        double credit;
        try {
            credit = Double.parseDouble(courseCredit.getText());
        } catch (Exception e) {
            show("Invalid credit!");
            return;
        }

        Course c = new Course(
                courseName.getText(),
                courseCode.getText(),
                credit,
                teacher1.getText(),
                teacher2.getText(),
                grade.getValue());

        CourseManager.getInstance().add(c);

        show("Course Added!");

        if (CourseManager.getInstance().reachedRequiredCredits())
            calcBtn.setDisable(false);

        courseName.clear();
        courseCode.clear();
        teacher1.clear();
        teacher2.clear();
        courseCredit.clear();
        grade.setValue(null);
    }

    private void show(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.show();
    }

    @FXML
    public void showResult() throws Exception {
        Stage stage = (Stage) calcBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gpa/GPAResult.fxml"));
        stage.setScene(new Scene(loader.load(), 960, 600));
    }
}
