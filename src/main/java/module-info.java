module World_3D.main {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires java.sql;
//    requires ORM;
    requires sqlite.jdbc;

    opens stuff to javafx.fxml;

    exports stuff;
}