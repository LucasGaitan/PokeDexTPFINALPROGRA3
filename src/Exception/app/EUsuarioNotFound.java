package Exception.app;

public class EUsuarioNotFound extends Exception{
    public EUsuarioNotFound (String msg) {
        super(msg);
    }


    @Override
    public String getMessage() {
        return super.getMessage() + "Usuario no encontrado";
    }
}
