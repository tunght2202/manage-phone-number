/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Thanh Tung
 */
public class Contact {
    String nameContact, phoneNumberContact;
    int idContacts, idLogin;

    public Contact() {
    }

    public Contact(String nameContact, String phoneNumberContact, int idContacts) {
        this.nameContact = nameContact;
        this.phoneNumberContact = phoneNumberContact;
        this.idContacts = idContacts;
    }

    public Contact(String nameContact, String phoneNumberContact, int idContacts, int idLogin) {
        this.nameContact = nameContact;
        this.phoneNumberContact = phoneNumberContact;
        this.idContacts = idContacts;
        this.idLogin = idLogin;
    }


    public String getNameContact() {
        return nameContact;
    }

    public void setNameContact(String nameContact) {
        this.nameContact = nameContact;
    }

    public String getPhoneNumberContact() {
        return phoneNumberContact;
    }

    public void setPhoneNumberContact(String phoneNumberContact) {
        this.phoneNumberContact = phoneNumberContact;
    }

    public int getIdContacts() {
        return idContacts;
    }

    public void setIdContacts(int idContacts) {
        this.idContacts = idContacts;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    @Override
    public String toString() {
        return "Contact{" + "nameContact=" + nameContact + ", phoneNumberContact=" + phoneNumberContact + ", idContacts=" + idContacts + ", idLogin=" + idLogin + '}';
    }

}
