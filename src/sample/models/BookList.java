package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookList {
    private static ObservableList<Book> tableList = FXCollections.observableArrayList();
    private static ObservableList<Book> bookList = FXCollections.observableArrayList();

    private static Integer max = 0;

    public static void add(Book book) {
        tableList.add(book);
        bookList.add(book);
        max++;

    }

    public static Integer getMax(){
        return max;
    }

    public static ObservableList<Book> getTableList(){
        return tableList;
    }

    public static boolean listIsEmpty(){
        return tableList.isEmpty();
    }

    public static void fillTestData(){
        add(new Book(0,"JAVA. Уроки для начинающих.", "А.Н.Васильев", 2019,"Научная литература"));
        add(new Book(1,"Структуры и алгоритмы обработки данных.", "Лафоре Роберт", 2020,"Научная литература"));
        add(new Book(2,"Война и Мир.", "Л.Н. Толстой", 2014,"Роман"));
    }

    //Поиск книги по автору или по названию//
    public static ObservableList<Book> findTableData(String nameData, String authorData, int i){
        ObservableList<Book> findBook = FXCollections.observableArrayList();
        if(i == 0){
            for(Book b : tableList){
                if(b.getBookName().equals(nameData)){
                    findBook.add(b);
                }
            }
            return findBook;
        }
        else if(i == 1){
            for(Book b : tableList) {
                if (b.getBookAuthor().equals(authorData)) {
                    findBook.add(b);
                }
            }
            return findBook;
        }else if(i == 2){
            for(Book b : tableList) {
                if (b.getBookAuthor().equals(authorData) && b.getBookName().equals(nameData)) {
                    findBook.add(b);
                }
            }
            return findBook;
        }
        else{
            return findBook;
        }
    }


    //Реализация кнопок выдать и получить
    public static void giveOut(int bookId, int userId){
        setAvailability(bookId,false);
        UserList.addBook(userId, getBook(bookId));
        tableList.remove(getBook(bookId));
    }

    public static void takeBook(int bookId, int userId){
        if(UserList.isFind(userId,bookId)) {
            setAvailability(bookId, true);
            tableList.add(UserList.request(userId, bookId));
            UserList.delete(userId, bookId);
        }
    }

    public static void setAvailability(int bookId, boolean b){
        for(Book book : bookList){
            if(book.getId().equals(bookId)){
                book.setAvailability(b);
            }
        }
    }

    public static boolean search(Integer id){
        for(Book b : tableList){
            if(b.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public static Book getBook(Integer id){
        for(Book b : bookList){
            if(b.getId().equals(id)){
                return b;
            }
        }
        return null;
    }

    public static boolean searchForAll(Integer id){
        for(Book b : bookList){
            if(b.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
