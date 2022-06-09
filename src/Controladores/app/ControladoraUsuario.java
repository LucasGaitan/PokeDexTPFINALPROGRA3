package Controladores.app;

import Entidad.app.Usuario;
import Exception.app.EUsuarioNotFound;
import Exception.app.EUsuarioPassIncorrecta;
import Interfaces.app.IAbm;

import java.util.HashSet;
import java.util.Iterator;

public class ControladoraUsuario implements IAbm<Usuario> {
    HashSet <Usuario> usuarios = new HashSet<Usuario>();

    @Override
    public void agregar(Usuario elemento) {
        usuarios.add(elemento);
    }

    @Override
    public Usuario borrar(Usuario elemento) {

        return null;
    }

    @Override
    public void modificar(Usuario elemento) {

    }

    public Usuario encontrarUsuario (String username)  {

        Iterator<Usuario> iterator = usuarios.iterator();
        boolean flag = false;
        Usuario encontrado = null;

        while (iterator.hasNext() && !flag){
            if ((iterator.next().getUserName().equals(username))){
                flag = true;
                encontrado = (Usuario) iterator.next();
            }
            iterator.next();
        }
        return encontrado;
    }

    public String mostrarInfoUsuarioAdmin(String username){
        return encontrarUsuario(username).toString();
    }

    public String mostrarInfoUsuarioUser(String username){
        return encontrarUsuario(username).toStringUser();
    }

    public StringBuilder listarUsuarios (){
        Iterator<Usuario> iterator = usuarios.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next());
        }
        return stringBuilder;
    }

    public Usuario login(String username, String password) throws EUsuarioPassIncorrecta, EUsuarioNotFound {
        Usuario encontrado = encontrarUsuario(username);
        int cantidadIntentos = 0;
        if (encontrado!=null){
            if (encontrado.getUserName().equals(username)){
                if (encontrado.getPassword().equals(password)){
                    return encontrado;
                }
                else {
                    cantidadIntentos++;
                    throw new EUsuarioPassIncorrecta("", cantidadIntentos);
                }
            }
            else {
                cantidadIntentos++;
                throw new EUsuarioPassIncorrecta("",cantidadIntentos);
            }
        }
        throw new EUsuarioNotFound("");
    }
}
