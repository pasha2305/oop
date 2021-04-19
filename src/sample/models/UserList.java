package sample.models;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.skin.CellSkinBase;

public class UserList {
    private ObservableList<User> userList = FXCollections.observableArrayList();

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

    public void fillTestData(){
        userList.add(new User("Кристина", "Саргсян", "Эдуардовна", "+79174999706"));
        userList.add(new User("Анна", "Юрченко", "Евгеньевна", "+79174999705"));
        userList.add(new User("Сергей", "Стрункин", "Максимович", "+79174567706"));
    }

    public boolean userListEmpty(){
        return userList.isEmpty();
    }
}
