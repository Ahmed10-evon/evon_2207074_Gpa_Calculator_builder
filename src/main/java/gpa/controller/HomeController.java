package gpa.controller;
import javafx.stage.Window;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    public void startApp() throws Exception {
        Stage stage = (Stage) javafx.stage.Window.getWindows().filtered(Window::isShowing).getFirst();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gpa/CourseEntry.fxml"));
        stage.setScene(new Scene(loader.load(), 960, 600));
    }
}
