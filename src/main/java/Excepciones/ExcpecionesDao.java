/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author Cristian
 */
public class ExcpecionesDao extends Exception {
     public ExcpecionesDao() {
    }

    public ExcpecionesDao(String message) {
        super(message);
    }

    public ExcpecionesDao(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcpecionesDao(Throwable cause) {
        super(cause);
    }

    public ExcpecionesDao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
