package com.company;

import java.util.HashSet;

public class ControladoraUsuario implements IAbm<Usuario>{
    HashSet <Usuario> usuarios = new HashSet<Usuario>();

    @Override
    public void agregar(Usuario elemento) {

    }

    @Override
    public Usuario borrar(Usuario elemento) {
        return null;
    }

    @Override
    public void modificar(Usuario elemento) {

    }
}
