module gpa {
    // JavaFX modules you need
    requires javafx.controls;
    requires javafx.fxml;

    // Export main package (optional if other modules need it)
    exports gpa;

    // Open controller package to JavaFX FXML loader
    opens gpa.controller to javafx.fxml;

    // Optional: open main package if your FXML files are in gpa
    opens gpa to javafx.fxml;
}
