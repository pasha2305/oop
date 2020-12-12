package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.models.Book;
import sample.models.BookList;

public class reportController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Yes;

    @FXML
    private ImageView No;

    @FXML
    private Label idBook;

    @FXML
    private Label nameBook;

    @FXML
    private Label authorBook;

    @FXML
    private Label genreBook;

    @FXML
    private Label warning1;

    @FXML
    private JFXTextField idField;

    @FXML
    private JFXButton request;

    @FXML
    private Label warningDelete1;

    @FXML
    private Label warning2;

    @FXML
    private Pane bookPane;

//    BookList bookList = new BookList();

    @FXML
    void initialize() {

    }

    public void requestOrder(ActionEvent event) {
        if(isDigit() && !fieldIsEmpty() && !BookList.listIsEmpty() && BookList.searchForAll(getId())){
            setPane(BookList.getBook(getId()));
        }
        else if(!isDigit()){
            System.out.println(1);
        }
        else if(fieldIsEmpty()){
            System.out.println(2);
        }
        else if(BookList.listIsEmpty()){
            System.out.println(3);
        }
        else if(!BookList.search(getId())){
            System.out.println(4);
        }
    }

    public boolean isDigit(){
        try{
           getId();
           return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean fieldIsEmpty(){
        return idField.getText().isEmpty();
    }

    public Integer getId(){
        return Integer.parseInt(idField.getText());
    }

    public void setPane(Book book){
        warning1.setVisible(false);
        warning2.setVisible(false);
        bookPane.setVisible(true);
        idBook.setText(book.getId().toString());
        nameBook.setText(book.getBookName());
        authorBook.setText(book.getBookAuthor());
        genreBook.setText(book.getGenre());
        if(book.isAvailability()) {
            No.setVisible(false);
            Yes.setVisible(true);
        }
        else {
            Yes.setVisible(false);
            No.setVisible(true);
        }
    }
}
