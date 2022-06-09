package Controladores.app;

import Entidad.app.Usuario;
import Interfaces.app.IAbm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ControladoraUsuario implements IAbm<Usuario> {
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

    public HashSet<Usuario> listar(){
        return null;
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
