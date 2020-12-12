package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.models.Book;
import sample.models.BookList;
import sample.models.User;
import sample.models.UserList;

public class findController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label warningDelete;

    @FXML
    private JFXTextField authorField;

    @FXML
    private JFXTextField nameField;

    @FXML
    private JFXButton findBtn;

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<Integer, Book> idColumn;

    @FXML
    private TableColumn<String, Book> nameColumn;

    @FXML
    private TableColumn<String, Book> authorColumn;

    @FXML
    private TableColumn<Integer, Book> yearColumn;

    @FXML
    private TableColumn<String , Book> jenreColumn;

    @FXML
    private JFXTextField bookId1;

    @FXML
    private JFXTextField number1;

    @FXML
    private JFXButton giveOut;

    @FXML
    private JFXTextField bookId2;

    @FXML
    private JFXTextField number2;

    @FXML
    private JFXButton receive;

    BookList bl = new BookList() ;

    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Integer, Book>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<String, Book>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<String, Book>("bookAuthor"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Integer, Book>("year"));
        jenreColumn.setCellValueFactory(new PropertyValueFactory<String, Book>("genre"));
        bookTable.setItems(bl.getTableList());
    }

    @FXML
    public void find(ActionEvent event){
        if(!findPaneIsEmpty()){
            if(!getNameField().isEmpty() && getAuthorField().isEmpty()){
                bookTable.setItems(BookList.findTableData(getNameField(),null,0));
            }else if(getNameField().isEmpty() && !getAuthorField().isEmpty()){
                bookTable.setItems(BookList.findTableData(null, getAuthorField(),1));
            }
            else{
                bookTable.setItems(BookList.findTableData(getNameField(),getAuthorField(),2));
            }
        }
        else if(findPaneIsEmpty()){
            System.out.println("Ошибка");
        }
    }

    @FXML
    public void giveOut(ActionEvent event) {
        if(!giveOutIsEmpty() && isDigit(getId1()) && isDigit(getNumber1())){
            if(BookList.search(Integer.parseInt(getId1())) && UserList.idSearch(Integer.parseInt(getNumber1()))){
                BookList.giveOut(Integer.parseInt(getId1()),Integer.parseInt(getNumber1()));

            }
            else {
                System.out.println(2);
            }
        }
        else{
            System.out.println(1);
        }
    }

    @FXML
    public void takeIn(ActionEvent event) {
        if(!takeInIsEmpty() && isDigit(getId2()) && isDigit(getNumber2())){
            if(UserList.idSearch(Integer.parseInt(getNumber2()))){
                BookList.takeBook(Integer.parseInt(getId2()),Integer.parseInt(getNumber2()));
            }
            else {
                System.out.println(2);
            }
        }
        else{
            System.out.println(1);
        }
    }

    public boolean isDigit(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String getAuthorField(){
        return authorField.getText();
    }

    public String getNameField(){
        return nameField.getText();
    }

    public String getId1(){
        return bookId1.getText();
    }

    public String getId2(){
        return bookId2.getText();
    }

    public String getNumber1(){
        return number1.getText();
    }

    public String getNumber2(){
        return number2.getText();
    }

    public boolean giveOutIsEmpty(){
        return (bookId1.getText().isEmpty() && number1.getText().isEmpty());
    }

    public boolean takeInIsEmpty(){
        return (bookId2.getText().isEmpty() && number2.getText().isEmpty());
    }

    public boolean findPaneIsEmpty(){
        return (getNameField().isEmpty() && getAuthorField().isEmpty());
    }
}
