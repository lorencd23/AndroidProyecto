package com.example.androidvinted.model.pojo;

public class User {
    private int idProducto;
    private String name;
    private String mail;
    private String pass;

    public User(int idProducto, String name, String mail, String pass) {
        this.idProducto = idProducto;
        this.name = name;
        this.mail = mail;
        this.pass = pass;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
