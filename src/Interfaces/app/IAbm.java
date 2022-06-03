package Interfaces.app;

public interface IAbm <T>{
    void agregar(T elemento);
    T borrar(T elemento);
    void modificar(T elemento);

}
