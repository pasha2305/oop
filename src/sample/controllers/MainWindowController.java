package sample.controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import sample.models.BookList;
import sample.models.UserList;


public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button usersBtn;

    @FXML
    private Button findBtn;

    @FXML
    private Button orderBtn;

    @FXML
    private Button reportBtn;

    @FXML
    private JFXButton closeBtn;

    @FXML
    private AnchorPane anchorHolder;

    private AnchorPane selectAnchor;

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void initialize() throws IOException {
         selectAnchor = FXMLLoader.load(getClass().getResource("../fxml/usersPage.fxml")); 
         setNode(selectAnchor);
         BookList.fillTestData();
         UserList.fillTestData();
    }

    @FXML
    void setNode(Node node){
        anchorHolder.getChildren().clear();
        anchorHolder.getChildren().add((Node) node);
    }

    @FXML
    void getPage(ActionEvent event) throws IOException {
        if (event.getSource() == usersBtn){
            selectAnchor = FXMLLoader.load(getClass().getResource("../fxml/usersPage.fxml"));
            setNode(selectAnchor);
        }
        else if (event.getSource() == findBtn){
            selectAnchor = FXMLLoader.load(getClass().getResource("../fxml/findPage.fxml"));
            setNode(selectAnchor);
        }
        else if(event.getSource() == orderBtn){
            selectAnchor = FXMLLoader.load(getClass().getResource("../fxml/orderPage.fxml"));
            setNode(selectAnchor);
        }
        else if(event.getSource() == reportBtn){
            selectAnchor = FXMLLoader.load(getClass().getResource("../fxml/reportPage.fxml"));
            setNode(selectAnchor);
        }
    }
}
