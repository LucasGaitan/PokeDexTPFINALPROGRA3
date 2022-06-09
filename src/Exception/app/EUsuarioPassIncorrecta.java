package Exception.app;

import Entidad.app.Usuario;

public class EUsuarioPassIncorrecta extends Exception{
    /*public boolean ExceptionLogin(Usuario encontrado, String password) throws Exception {
        if (encontrado == null){
            throw new Exception("Usuario o contraseña incorrectos");
        }
        if (!encontrado.getPassword().equals(password)){
            throw new Exception("Usuario o contraseña incorrectos");
        }
        return true;

    }

    public boolean usuarioNotFoundException(Usuario encontrado) throws Exception {
        if (encontrado == null){
            throw new Exception("No existe el usuario");
        }
        return true;
    }*/

    private int cantidadIntentos;

    public EUsuarioPassIncorrecta (String msg, int cantidadIntentos) {
        super(msg);
        this.cantidadIntentos = cantidadIntentos;
    }

    public int getCantidadIntentos() {
        return cantidadIntentos;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Usuario o contraseña incorrecta, le quedan "+ this.cantidadIntentos;
    }
}
