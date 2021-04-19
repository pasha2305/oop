package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookList {
    private ObservableList<Book> bookList = FXCollections.observableArrayList();
    private int Max_element;

    

    public void add(Book book){
        bookList.add(book);
    }


}
