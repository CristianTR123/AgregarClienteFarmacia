module vista {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    opens vista to javafx.fxml;
    exports vista;
    opens modelo;
}
