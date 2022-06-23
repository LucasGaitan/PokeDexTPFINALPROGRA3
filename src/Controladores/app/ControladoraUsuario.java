package Controladores.app;

import Entidad.app.Usuario;
import Exception.app.EDatosVacios;
import Exception.app.ENotFoundException;
import Exception.app.EUsuarioExiste;
import Exception.app.EUsuarioPassIncorrecta;
import Interfaces.app.IAbm;
import Entidad.app.Pokedex;

import java.util.*;

public class ControladoraUsuario implements IAbm<Usuario> {
    HashMap <String,Usuario> usuarios = new HashMap<String, Usuario>();
    private int idUsuarios = 0;
    public void testUsuario ()
    {
        Usuario user=new Usuario(1, "admin", "admin",true,new Pokedex());
        usuarios.put(user.getUserName(), user);
    }

    @Override
    public void agregar(Usuario elemento ) throws EUsuarioExiste, EDatosVacios {
        if(elemento.getUserName().equals("") || elemento.getPassword().equals("")){
            throw new EDatosVacios("Por favor, ingrese sus datos");
        }
        else if (usuarios.containsKey(elemento.getUserName())){
            throw new EUsuarioExiste("El usuario ya existe en el sistema");
        }
        else {
            usuarios.put(elemento.getUserName(),elemento);
        }


    }

    @Override
    public Usuario borrar(Usuario elemento) {

        return null;
    }

    @Override
    public void modificar(Usuario elemento) {

    }

    public Usuario encontrarUsuario(String username) {

        Iterator<Map.Entry<String, Usuario>> iterator = usuarios.entrySet().iterator();
        boolean flag = false;
        Usuario encontrado = null;

        while (iterator.hasNext() && !flag) {
            Map.Entry<String, Usuario> entradaMapa = iterator.next();
            if ((entradaMapa.getKey().equals(username))) {
                flag = true;
                encontrado = entradaMapa.getValue();
            }
        }
        return encontrado;
    }

    public String mostrarInfoUsuarioAdmin(String username) {
        return encontrarUsuario(username).toString();
    }

    public String mostrarInfoUsuarioUser(String username) {
        return encontrarUsuario(username).toStringUser();
    }

    /*public StringBuilder listarUsuarios (){
        Iterator<Usuario> iterator = usuarios.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next());
        }
        return stringBuilder;
    }*/

    public Usuario login(String username, String password) throws EUsuarioPassIncorrecta {
        Usuario encontrado = encontrarUsuario(username);
        if (encontrado != null){
            if (!encontrado.getUserName().equals(username) && !encontrado.getPassword().equals(password)) {
                throw new EUsuarioPassIncorrecta("Usuario o contraseña incorrecta");
            }
        }
        else {
            throw new EUsuarioPassIncorrecta("Usuario o contraseña incorrecta");
        }

        return encontrado;
        /*
        if (encontrado!=null){
            if (encontrado.getUserName().equals(username)){
                if (encontrado.getPassword().equals(password)){
                    return encontrado;
                }
                else {
                    throw new EUsuarioPassIncorrecta("");
                }
            }
            else {
                throw new EUsuarioPassIncorrecta("");
            }
        }
        throw new EUsuarioPassIncorrecta("");

         */

    }

    String borrarUsuarioLista(Usuario elemento) throws ENotFoundException
    {
        boolean found = false;
        Iterator<Map.Entry<String, Usuario>> iterator = usuarios.entrySet().iterator();
        Usuario aBorrar = new Usuario();
        String response = new String();
        while (iterator.hasNext() && !found) {
            Map.Entry<String, Usuario> entradaMapa = iterator.next();
            if (entradaMapa.getKey().equals(elemento.getUserName())) {
                aBorrar = entradaMapa.getValue();
                found = true;
            }
        }
        if (usuarios.containsKey(aBorrar.getUserName())) {
            usuarios.remove(aBorrar.getUserName());

        } else {
            throw new ENotFoundException("El usuario no existe");
        }
        return response;
    }

    /*public List<String> listarUsuarios() // HACER
    {
        List<Usuario> lista = new ArrayList<Usuario>();
        Iterator<Map.Entry<String, Usuario>> iterator = usuarios.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Usuario> entradaMapa = iterator.next();
            lista.add()
        }
        return lista;
    }*/



    public Usuario crearUsuario(String username, String password){
        Usuario usuario = new Usuario(getCurrentId()+1, username, password, false, new Pokedex());
        return usuario;
    }
    private int getCurrentId ()
    {
        return usuarios.size();
    }


}
