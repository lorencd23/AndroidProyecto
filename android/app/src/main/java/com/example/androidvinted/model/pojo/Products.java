package com.example.androidvinted.model.pojo;

public class Products {
    private int idProducto;
    private String name;
    private String prize;
    private String description;
    private String existences;
    private String genero;
    private String img;


    public Products(int idProducto, String name, String prize, String description, String existences, String genero, String img) {
        this.idProducto = idProducto;
        this.name = name;
        this.prize = prize;
        this.description = description;
        this.existences = existences;
        this.genero = genero;
        this.img = img;
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

    public String getPrize() {
        return prize + "€";
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExistences() {
        return existences;
    }

    public void setExistences(String existences) {
        this.existences = existences;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
