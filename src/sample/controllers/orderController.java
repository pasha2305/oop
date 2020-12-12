package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.models.Book;
import sample.models.BookList;

public class orderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label warningDelete;

    @FXML
    private JFXTextField bookName;

    @FXML
    private JFXTextField bookAuthor;

    @FXML
    private JFXTextField bookYear;

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXButton orderBtn;

    @FXML
    private JFXComboBox<String> bookJenre;

    BookList bookList = new BookList();
    ObservableList<String> listJenre = FXCollections.observableArrayList();

    @FXML
    public void addOrder(ActionEvent event){
        if(!fieldsIsEmpty() && checkNumber()){
            bookList.add(getFields());
        }
        else if(fieldsIsEmpty()){
            System.out.println("Поля пустые!");
        }
        else if(!checkNumber()){
            System.out.println("Некорректно указан год.");
        }
    }

    @FXML
    public void initialize() {
        listJenre.add("Роман");
        listJenre.add("Детектив");
        listJenre.add("Фантастика");
        listJenre.add("Ужасы");
        listJenre.add("Дневник");
        listJenre.add("Научная литература");
        listJenre.add("Психология");
        bookJenre.setItems(listJenre);
        bookJenre.setValue("Роман");
    }

    public boolean fieldsIsEmpty(){
        return (bookName.getText().isEmpty() || bookAuthor.getText().isEmpty() || bookYear.getText().isEmpty());
    }

    public boolean checkNumber(){
        try{
            if(Integer.parseInt(bookYear.getText()) < 2021)
                return true;
            return false;
        }catch (Exception e){
            return false;
        }
    }

    public Book getFields(){
        return new Book(BookList.getMax(), bookName.getText(), bookAuthor.getText(), Integer.parseInt(bookYear.getText()), bookJenre.getValue());
    }
}