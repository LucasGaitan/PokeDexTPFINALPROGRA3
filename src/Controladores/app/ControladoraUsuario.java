package Controladores.app;

import Entidad.app.Usuario;
import Exception.app.EDatosVacios;
import Exception.app.EUsuarioExiste;
import Exception.app.EUsuarioPassIncorrecta;
import Interfaces.app.IAbm;
import Entidad.app.Pokedex;

import java.util.*;

public class ControladoraUsuario implements IAbm<Usuario> {
    HashMap<String, Usuario> usuarios;
    //constructor controladora de usuario para obtener hashmap desde aplicacion
    public ControladoraUsuario(HashMap<String, Usuario> usuarioHashMap) {
        this.usuarios = usuarioHashMap;
    }

    ///agrego un elemento al hashmap
    @Override
    public void agregar(Usuario elemento) throws EUsuarioExiste, EDatosVacios { ///elevo la excepcion
        if (elemento.getUserName().equals("") || elemento.getPassword().equals("")) { ///si se recibe un usuario con username o contraseña vacio se lanza exception
            throw new EDatosVacios("Por favor, ingrese sus datos");
        } else if (usuarios.containsKey(elemento.getUserName())) { ///si ya existe el username en el sistema se lanza excepcion
            throw new EUsuarioExiste("El usuario ya existe en el sistema");
        } else {
            usuarios.put(elemento.getUserName(), elemento); ///se agrega usuario al hashmap
        }


    }

    public void setUsuarios(HashMap<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public Usuario borrar(Usuario elemento) {

        usuarios.remove(elemento.getUserName());
        return elemento;
    }

    @Override
    public void modificar(Usuario elemento) {
        usuarios.replace(elemento.getUserName(), elemento);
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


    public Usuario login(String username, String password) throws EUsuarioPassIncorrecta {
        Usuario encontrado = encontrarUsuario(username);
        if (encontrado != null) {
            if (!encontrado.getUserName().equals(username) || !encontrado.getPassword().equals(password)) {
                throw new EUsuarioPassIncorrecta("Usuario o contraseña incorrecta");
            }
        } else {
            throw new EUsuarioPassIncorrecta("Usuario o contraseña incorrecta");
        }

        return encontrado;
    }


    public Usuario crearUsuario(String username, String password) {
        Usuario usuario = new Usuario(getCurrentId() + 1, username, password, false, new Pokedex());
        return usuario;
    }
    public Usuario crearUsuarioAdmin (String username, String password, boolean admin)
    {
        Usuario usuario = new Usuario(getCurrentId() + 1, username, password, admin, new Pokedex());
        return usuario;
    }
    private int getCurrentId() {
        return usuarios.size();
    }

    public HashMap<String, Usuario> getHashMapUsuarios() {
        return this.usuarios;
    }

    public ArrayList<Usuario> castHashMapToArrayList(HashMap<String, Usuario> usuarioHashMap) {
        ArrayList<Usuario> lista = new ArrayList<>();
        Iterator<Map.Entry<String, Usuario>> iterator = usuarios.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Usuario> entradaMapa = iterator.next();
            lista.add(entradaMapa.getValue());
        }
        return lista;
    }

    public void loadAdminInicio(){
        if (usuarios.isEmpty()){
            usuarios.put(loadAdmin().getUserName(),loadAdmin());
        }
    }

    public Usuario loadAdmin() {
        Usuario user = new Usuario(1, "admin", "admin", true, new Pokedex());
        return user;
    }
}
