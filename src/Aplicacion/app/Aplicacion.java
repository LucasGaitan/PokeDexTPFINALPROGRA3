package Aplicacion.app;

import Controladores.app.ControladoraPokemon;
import Controladores.app.ControladoraUsuario;

public class Aplicacion {
    private ControladoraUsuario controladoraUsuario;
    private ControladoraPokemon controladoraPokemon;

    public Aplicacion (){
        controladoraUsuario = new ControladoraUsuario();
        controladoraPokemon = new ControladoraPokemon();
    }


    public ControladoraPokemon getControladoraPokemon() {
        return controladoraPokemon;
    }

    public ControladoraUsuario getControladoraUsuario() {
        return controladoraUsuario;
    }
}
