/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thanh Tung
 */
public class LoginAccount {
    int idLogin;
    String loginName, LoginPassword;

    public LoginAccount(int idLogin, String loginName, String LoginPassword) {
        this.idLogin = idLogin;
        this.loginName = loginName;
        this.LoginPassword = LoginPassword;
    }

    public LoginAccount() {
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return LoginPassword;
    }

    public void setLoginPassword(String LoginPassword) {
        this.LoginPassword = LoginPassword;
    }
    
    
}
