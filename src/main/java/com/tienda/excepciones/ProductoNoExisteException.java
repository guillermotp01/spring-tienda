package com.tienda.excepciones;

public class ProductoNoExisteException extends Exception{
    public ProductoNoExisteException(){
        super();
    }
    public ProductoNoExisteException(String messsage){
        super(messsage);
    }
}
