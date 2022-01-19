package Util.pojo;

import java.util.ArrayList;

public class ChatCreateUserPOJO {
    String username;
    String password;
    String email;
    String name;
    String surname;
    String chat_nickname;
    ArrayList<Integer> departments;
    ArrayList<Integer> departments_read;
    ArrayList<Integer> department_groups;
    ArrayList<Integer> user_groups;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getChat_nickname() {
        return chat_nickname;
    }

    public void setChat_nickname(String chat_nickname) {
        this.chat_nickname = chat_nickname;
    }

    public ArrayList<Integer> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Integer> departments) {
        this.departments = departments;
    }

    public ArrayList<Integer> getDepartments_read() {
        return departments_read;
    }

    public void setDepartments_read(ArrayList<Integer> departments_read) {
        this.departments_read = departments_read;
    }

    public ArrayList<Integer> getDepartment_groups() {
        return department_groups;
    }

    public void setDepartment_groups(ArrayList<Integer> department_groups) {
        this.department_groups = department_groups;
    }

    public ArrayList<Integer> getUser_groups() {
        return user_groups;
    }

    public void setUser_groups(ArrayList<Integer> user_groups) {
        this.user_groups = user_groups;
    }






}
