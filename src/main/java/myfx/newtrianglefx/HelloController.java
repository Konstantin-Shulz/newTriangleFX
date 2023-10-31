package myfx.newtrianglefx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HelloController {
    @FXML
    private TableColumn<OTriangle, Double> a;
    @FXML
    private TableColumn<OTriangle, Double> b;
    @FXML
    private Button btnLoad;
    @FXML
    private TableColumn<OTriangle, Double> c;
    @FXML
    private TableColumn<OTriangle, Double> perim;
    @FXML
    private TableView<OTriangle> table;
    @FXML
    private TextField txtFname;
    @FXML
    void loadCarsFromFile(ActionEvent event) {
    }
    @FXML
    ListView<OTriangle> trList;
    ObservableList<OTriangle> triangles = FXCollections.observableArrayList();
    public void initialize() throws Exception {
        triangles.add(new OTriangle(15, 16, 21));
        trList.setItems(triangles);
        initTable();
    }

    private void initTable() {
        table.setItems(triangles);
        table.getColumns().clear();
        table.setEditable(true);

        //TableColumn<OTriangle, Double> columnA = new TableColumn<>("A");
        a.setCellValueFactory(new PropertyValueFactory<>("a")); //как извлекать данные из объекта
        //как нарисовать в каждой ячейке столбца поле для ввода
        a.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        //TableColumn<OTriangle, Double> columnB = new TableColumn<>("B");
        b.setCellValueFactory(new PropertyValueFactory<>("b"));
        b.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        //TableColumn<OTriangle, Double> columnC = new TableColumn<>("C");
        c.setCellValueFactory(new PropertyValueFactory<>("c"));
        c.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        //perim.setCellFactory(OTriangle.getPerim(triangles));

        //table.getColumns().addAll(columnA, columnB, columnC);
    }

    @FXML
    private void loadFromFile(){
        String fname = txtFname.getText();
        try{
            List<String> lines = Files.readAllLines(Path.of(fname));
            for (String s: lines ) {
                String[] words = s.split(" ");
                OTriangle tri = new OTriangle(Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2]));
                triangles.add(tri);
            }

        }catch (Exception e)
        {}
    }





















}