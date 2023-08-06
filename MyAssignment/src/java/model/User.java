/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thanh Tung
 */
public class User {
    String logginName, nameUser, phoneNumberUser, imgUser;
    int idUser,idLogin,role;

    public User() {
    }

    public User(String nameUser, String phoneNumberUser, String imgUser) {
        this.nameUser = nameUser;
        this.phoneNumberUser = phoneNumberUser;
        this.imgUser = imgUser;
    }

    public User(String nameUser, String phoneNumberUser, String imgUser, int idUser, int idLogin) {
        this.nameUser = nameUser;
        this.phoneNumberUser = phoneNumberUser;
        this.imgUser = imgUser;
        this.idUser = idUser;
        this.idLogin = idLogin;
    }

    public User(String nameUser, String phoneNumberUser, String imgUser, int idUser, int idLogin, int role) {
        this.nameUser = nameUser;
        this.phoneNumberUser = phoneNumberUser;
        this.imgUser = imgUser;
        this.idUser = idUser;
        this.idLogin = idLogin;
        this.role = role;
    }

    public User(String logginName, String nameUser, String phoneNumberUser, String imgUser, int idUser, int idLogin, int role) {
        this.logginName = logginName;
        this.nameUser = nameUser;
        this.phoneNumberUser = phoneNumberUser;
        this.imgUser = imgUser;
        this.idUser = idUser;
        this.idLogin = idLogin;
        this.role = role;
    }

    public User(String logginName, String nameUser, String phoneNumberUser, int role) {
        this.logginName = logginName;
        this.nameUser = nameUser;
        this.phoneNumberUser = phoneNumberUser;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public String getLogginName() {
        return logginName;
    }

    public void setLogginName(String logginName) {
        this.logginName = logginName;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPhoneNumberUser() {
        return phoneNumberUser;
    }

    public void setPhoneNumberUser(String phoneNumberUser) {
        this.phoneNumberUser = phoneNumberUser;
    }

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    @Override
    public String toString() {
        return "User{" + "nameUser=" + nameUser + ", phoneNumberUser=" + phoneNumberUser + ", imgUser=" + imgUser + ", idUser=" + idUser + ", idLogin=" + idLogin + '}';
    }


    
    
}
