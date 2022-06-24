package Entidad.app;

import javafx.fxml.Initializable;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;

public class Pokemon implements Serializable {
    private int id;
    private String name;
    private String sprite;
    private ArrayList <String> type;
    private ArrayList<String> abilities;

    public Pokemon (int id, String name, String sprite, ArrayList<String> type, ArrayList<String> abilities) {
        this.id = id;
        this.name = name;
        this.sprite = sprite;
        this.type = type;
        this.abilities = abilities;
    }

    public Pokemon(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public ArrayList<String> getType() {
        return type;
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

    @Override
    public boolean equals(Object o) {
        boolean esIgual = false;
        if (o!=null) {
            if (o instanceof Pokemon){
                Pokemon otro = new Pokemon();
                if (getId() == ((Pokemon) o).getId()){
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
