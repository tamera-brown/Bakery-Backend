package com.tp.bakery.execptions;

public class NullDessertImageException extends Exception {
    NullDessertImageException(String message){
        super(message);
    }
    NullDessertImageException(String message, Throwable innerException){
        super(message,innerException);
    }
}
