package sample.models;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public class User {
    private String name;
    private String soname;
    private String middleName;
    private String phone;
    private Integer number;
    private ObservableList<Book> books = FXCollections.observableArrayList();

    public User(String name, String soname, String middleName, String phone) {
        this.name = name;
        this.soname = soname;
        this.middleName = middleName;
        this.phone = phone;
        this.number = this.hashCode();
    }

    public String getName() {
        return name;
    }

    public String getSoname() {
        return soname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getNumber() {
        return number;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ObservableList<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(soname, user.soname) &&
                Objects.equals(middleName, user.middleName) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(number, user.number);
    }

    @Override
    public int hashCode() {
        if (Objects.hash(name, soname, middleName, phone, number) < 0) {
            return Objects.hash(name, soname, middleName, phone, number) * (-1);
        }
        else {
            return Objects.hash(name, soname, middleName, phone, number);
        }
    }
}
