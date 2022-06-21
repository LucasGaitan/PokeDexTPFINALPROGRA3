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

    String borrarUsuarioLista (Usuario u) //testear
    {
        boolean found=false;
        Iterator i=usuarios.iterator();
        Usuario aBorrar=new Usuario();
        String response=new String();
        while (i.hasNext() && !found)
        {
            if ((Usuario)i.next()==u)
            {
                aBorrar=(Usuario)i.next();
                found=true;
            }
        }
        if (usuarios.contains(aBorrar))
        {
            response=u.getUserName();
            usuarios.remove(aBorrar);

        }
        else
        {
            ///throw usuarionotfoundexception
        }
        return response;
    }

    public List <String> listarUsuarios () //test
    {
        List<String> lista=new ArrayList<String>();
        for (Usuario u:usuarios)
        {
            Usuario usuario=new Usuario();
            usuario.setUserName(u.getUserName());
        }
        return lista;
    }

}
