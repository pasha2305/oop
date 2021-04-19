package sample.controllers;

import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.models.User;
import sample.models.UserList;

public class usersController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<User> usersTable;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> sonameColumn;

    @FXML
    private TableColumn<User, String> middleColumn;

    @FXML
    private TableColumn<User, Integer> phoneColumn;

    @FXML
    private TableColumn<User, Integer> numberColumn;

    @FXML
    private JFXTextField nameField;

    @FXML
    private JFXTextField sonameField;

    @FXML
    private JFXTextField middlenameField;

    @FXML
    private JFXTextField phoneField;

    @FXML
    private JFXTextField deleteField;

    @FXML
    private JFXButton addBtn;

    @FXML
    private Label warningDelete;

    @FXML
    private Label warning;

    UserList userList = new UserList();

    @FXML
    void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        sonameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("soname"));
        middleColumn.setCellValueFactory(new PropertyValueFactory<User, String>("middleName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("phone"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<User, Integer>("number"));
        userList.fillTestData();
        usersTable.setItems(userList.getUserList());
    }

    @FXML
    public void clickOnAddBtn(ActionEvent event) {
        if (userList.unique(getFields()) && !is_empty() && checkNumber()) {
            warning.setVisible(false);
            warningDelete.setVisible(false);
            userList.add(getFields());
        } else if (is_empty()) {
            setWarning("Заполните все поля!");
        } else if(!checkNumber()){
            setWarning("Номер указан неверно!");
        } else {
            setWarning("Такой читатель уже есть!");
        }
    }

    public User getFields() {
        return new User(nameField.getText(), sonameField.getText(), middlenameField.getText(), phoneField.getText());
    }

    public boolean is_empty() {
        return nameField.getText().isEmpty() || sonameField.getText().isEmpty() || middlenameField.getText().isEmpty() || phoneField.getText().isEmpty();
    }

    public void setWarning(String text) {
        warning.setText(text);
        warning.setVisible(true);
    }

    public boolean checkNumber() {
        if (phoneField.getText().length() == 10 && phoneField.getText().charAt(0) != '+') {
            try {
                Integer.parseInt(phoneField.getText());
                return true;
            } catch (Exception e) {
                setWarning("Ошибка при вводе номера!");
                return false;
            }
        }  else if (phoneField.getText().length() == 12) {
            System.out.println(phoneField.getText());
            if (phoneField.getText().charAt(0) == '+') {
                String tmp;
                tmp = phoneField.getText().substring(1);
                try{
                    Long.parseLong(tmp);
                    return true;
                }catch (Exception e){
                    return false;
                }
            }
            return false;
        }
        else {
            setWarning("Номер указан неверно!");
            return false;
        }
    }

    @FXML
    public void clickOnDeleteBtn(ActionEvent event) {
        if(!userList.userListEmpty() && !delete_isEmpty()) {
            if (userList.delete(deleteField.getText())) {
            }
        }
        else if(delete_isEmpty()){
            setDeleteWarning("Заполните поле!");
        }
        else if(userList.userListEmpty()){
            setDeleteWarning("Список читателей пуст!");
        }
    }

    public boolean delete_isEmpty(){
        return deleteField.getText().isEmpty();
    }

    public void setDeleteWarning(String text) {
        warningDelete.setText(text);
        warningDelete.setVisible(true);
    }
}

