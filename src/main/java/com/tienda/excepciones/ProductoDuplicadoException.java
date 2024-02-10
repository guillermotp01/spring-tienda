package com.tienda.excepciones;

public class ProductoDuplicadoException extends Exception{
    public ProductoDuplicadoException(){
        super();
    }
    public ProductoDuplicadoException(String mensaje){
        super(mensaje);
    }
}
