package com.Entidad;

import java.util.ArrayList;

public class Pokemon {
    private int id;
    private String name;
    private String sprite;
    private ArrayList <String> type;
    private ArrayList<String> abilities;

    public Pokemon(int id, String name, String sprite, ArrayList<String> type, ArrayList<String> abilities) {
        this.id = id;
        this.name = name;
        this.sprite = sprite;
        this.type = type;
        this.abilities = abilities;
    }

    public Pokemon(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public String getSprite() {
        return sprite;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sprite='" + sprite + '\'' +
                ", type=" + type +
                ", abilities=" + abilities +
                '}';
    }
}
