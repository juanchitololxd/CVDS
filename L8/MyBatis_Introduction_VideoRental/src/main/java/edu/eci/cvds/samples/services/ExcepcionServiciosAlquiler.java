package edu.eci.cvds.samples.services;

public class ExcepcionServiciosAlquiler extends Exception{
    public ExcepcionServiciosAlquiler(String msg, Exception ex) {
        super(msg);
    }
    
    
    public ExcepcionServiciosAlquiler(String msg) {
        super(msg);
    }
}
