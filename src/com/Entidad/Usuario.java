package com.Entidad;

import com.company.Pokedex;

import java.util.Objects;

public class Usuario {
    private int id;
    private String userName;
    private String password;
    private boolean admin;
    private Pokedex pokedex;

    public Usuario(int id, String userName, String password, boolean admin, Pokedex pokedex) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.pokedex = pokedex;
    }

    public Usuario() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", pokedex=" + pokedex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        boolean esIgual = false;
        if (o!=null) {
            if (o instanceof Usuario){
                Usuario otro = new Usuario();
                if (getId() == ((Usuario) o).getId()){
                    esIgual = true;
                }
            }
        }

        return esIgual;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
