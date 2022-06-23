package Aplicacion.app;

import Controladores.app.ControladoraArchivoUsuarios;
import Controladores.app.ControladoraJSON;
import Controladores.app.ControladoraPokemon;
import Controladores.app.ControladoraUsuario;
import Entidad.app.Pokemon;
import Entidad.app.Usuario;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Aplicacion {
    private LinkedHashSet<Pokemon> listaDePokemon;
    private HashMap<String, Usuario> usuarios;
    private ControladoraUsuario controladoraUsuario;
    private ControladoraPokemon controladoraPokemon;
    private ControladoraJSON controladoraJSON;
    private ControladoraArchivoUsuarios controladoraArchivoUsuarios;

    public Aplicacion (){
        this.listaDePokemon = new LinkedHashSet<>();
        this.usuarios = new HashMap<>();
        this.controladoraJSON = new ControladoraJSON("Pokemons");
        this.controladoraUsuario = new ControladoraUsuario(usuarios);
        this.controladoraPokemon = null;
        this.controladoraArchivoUsuarios = new ControladoraArchivoUsuarios();
    }

    public void iniciarPrograma(){
        this.listaDePokemon = controladoraJSON.generarPokemon();
        this.controladoraPokemon = new ControladoraPokemon(listaDePokemon);
        controladoraUsuario.setUsuarios(controladoraArchivoUsuarios.agregarFiletoHashMap(new File("usuarios.bin")));
    }

    public LinkedHashSet<Pokemon> getListaDePokemon() {
        return listaDePokemon;
    }


    public ControladoraArchivoUsuarios getControladoraArchivoUsuarios() {
        return controladoraArchivoUsuarios;
    }

    public ControladoraPokemon getControladoraPokemon() {
        return controladoraPokemon;
    }

    public ControladoraUsuario getControladoraUsuario() {
        return controladoraUsuario;
    }
}
