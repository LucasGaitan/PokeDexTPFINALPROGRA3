package Entidad.app;

import java.util.ArrayList;
import java.util.Objects;

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

    public int getId() {
        return id;
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

    public int generarId()
    {
        int id=1;
        return id;
    }

    public void cargarTipos(Pokemon p, String tipo1)
    {
        p.type.add(tipo1);
    }

    public void cargarTipos(Pokemon p, String tipo1, String tipo2)
    {
        p.type.add(tipo1);
        p.type.add(tipo2);
    }

    public void cargarHabilidades(Pokemon p, String habilidad1, String habilidad2, String habilidad3, String habilidad4)
    {
        p.type.add(habilidad1);
        p.type.add(habilidad2);
        p.type.add(habilidad3);
        p.type.add(habilidad4);
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
