module com.example.calctwo {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.calctwo to javafx.fxml;
    exports com.example.calctwo;
}