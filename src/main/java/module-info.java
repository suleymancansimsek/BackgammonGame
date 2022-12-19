module com.example.backgammongame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.backgammongame to javafx.fxml;
    exports com.example.backgammongame;
}