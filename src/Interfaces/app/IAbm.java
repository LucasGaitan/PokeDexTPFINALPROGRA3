package Interfaces.app;

import Entidad.app.Usuario;
import Exception.app.EUsuarioExiste;

import java.io.File;

public interface IAbm <T>{
    void agregar(T elemento) throws Exception;
    T borrar(T elemento);
    void modificar(T elemento);
}
