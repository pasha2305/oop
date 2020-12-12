package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.skin.CellSkinBase;

public class UserList {
    private static ObservableList<User> userList = FXCollections.observableArrayList();

    public void add(User user){
        if(user.getPhone().length() == 10){
            StringBuilder str = new StringBuilder(user.getPhone());
            str.insert(0,'+');
            str.insert(1,7);
            user.setPhone(str.toString());
        }
        userList.add(user);
    }

    public boolean delete(String str){
        for(User u : userList){
            try {
                if(u.getNumber() == Integer.parseInt(str)) {
                    userList.remove(u);
                    return true;
                }
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    public boolean unique(User user){
        if(user.getPhone().length() == 10){
            StringBuilder str = new StringBuilder(user.getPhone());
            str.insert(0,'+');
            str.insert(1,7);
            user.setPhone(str.toString());
        }
        if(userList.contains(user)){
            return false;
        }
        return true;
    }

    public ObservableList<User> getUserList(){
        return userList;
    }

    public static void fillTestData(){
        userList.add(new User("Кристина", "Саргсян", "Эдуардовна", "+79174999706"));
        userList.add(new User("Сергей", "Стрункин", "Максимович", "+79174567706"));
    }

    public boolean userListEmpty(){
        return userList.isEmpty();
    }

    public static void addBook(int id, Book book){
        for(User u : userList){
            if(u.getNumber().equals(id)){
                u.getBooks().add(book);
            }
        }
    }

    public static Book request(int id, int bookId){
        for(User u : userList){
            if(u.getNumber().equals(id)){
                for(Book b : u.getBooks()){
                    if (b.getId().equals(bookId)) {
                        return b;
                    }
                }
            }
        }
        return null;
    }

    public static boolean isFind(int id, int bookId){
        for(User u : userList){
            if(u.getNumber().equals(id)){
                for(Book b : u.getBooks()){
                    if (b.getId().equals(bookId)) {
                        return true;
                    }
                }
            }
        }
        System.out.println(1);
        return false;
    }

    public static void delete(int id, int bookId){
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getNumber().equals(id)){
                for(int j = 0; j < userList.get(i).getBooks().size(); j++){
                    if (userList.get(i).getBooks().get(j).getId().equals(bookId)) {
                        userList.get(i).getBooks().remove(j);
                    }
                }
            }
        }
    }

    public static boolean idSearch(int id){
        for(User u : userList){
            if(u.getNumber().equals(id))
                return true;
        }
        return false;
    }


}
