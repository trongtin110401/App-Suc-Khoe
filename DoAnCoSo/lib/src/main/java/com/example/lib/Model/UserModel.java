package com.example.lib.Model;

public class UserModel {
    private float iduser;
    private String Account;
    private String Password;
    private String email;


    // Getter Methods

    public float getIduser() {
        return iduser;
    }

    public String getAccount() {
        return Account;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return email;
    }

    // Setter Methods

    public void setIduser(float iduser) {
        this.iduser = iduser;
    }

    public void setAccount(String Account) {
        this.Account = Account;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
