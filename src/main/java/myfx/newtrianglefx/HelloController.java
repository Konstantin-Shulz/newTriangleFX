package myfx.newtrianglefx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HelloController {
    @FXML
    private TableColumn<OTriangle, Double> colA;
    @FXML
    private TableColumn<OTriangle, Double> colB;
    @FXML
    private Button btnLoad;
    @FXML
    private TableColumn<OTriangle, Double> colC;
    @FXML
    private TableColumn<OTriangle, Double> colPerim;
    @FXML
    private TableColumn<OTriangle, Double> colArea;
    @FXML
    private TableView<OTriangle> table;
    @FXML
    private TextField txtFname;

    @FXML
    ListView<OTriangle> trList;

    ObservableList<OTriangle> triangles = FXCollections.observableArrayList();
    public void initialize() throws Exception {
        triangles.add(new OTriangle(15, 16, 21));
       // trList.setItems(triangles);
        initTable();
    }

    private void initTable() {
        table.setItems(triangles);
      //  table.getColumns().clear();
        table.setEditable(true);


        colA.setCellValueFactory(new PropertyValueFactory<>("a"));
        colA.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));


        colB.setCellValueFactory(new PropertyValueFactory<>("b"));
        colB.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        colC.setCellValueFactory(new PropertyValueFactory<>("c"));
        colC.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));

        colPerim.setCellValueFactory(new PropertyValueFactory<>("perim"));

        colArea.setCellValueFactory(new PropertyValueFactory<>("area"));
    }

    @FXML
    private void loadFromFile(){
        String fname = txtFname.getText();
        try{
            List<String> lines = Files.readAllLines(Path.of(fname));
            for (String s: lines ) {
                String[] words = s.split(" ");
                OTriangle tri = new OTriangle(Double.parseDouble(words[0]), Double.parseDouble(words[1]), Double.parseDouble(words[2]));
                triangles.add(tri);
            }

        }catch (Exception e)
        {
            System.out.println("ошибка чтения");
        }
    }





















}