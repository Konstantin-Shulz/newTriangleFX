module myfx.newtrianglefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens myfx.newtrianglefx to javafx.fxml;
    exports myfx.newtrianglefx;
}