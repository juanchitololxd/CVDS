package edu.eci.cvds.servlet.model;

import java.util.List;

import java.util.Random;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "guessBean")
// @Named
@SessionScoped 
public class GuessBean {
    private int premioStart = 100000;
    private int disminucion;
    private int numeroGuess; 
    private int premio;   
    private List<Integer> intentos;
    private String status = "Sin ganar";

    public GuessBean(){
        this.init();
    }

    private void init(){
        this.premio = premioStart;
        this.disminucion = 10000;
        this.numeroGuess = (new Random()).nextInt(50);
        this.intentos = new ArrayList<Integer>();
        this.status = "Sin ganar";
    }

    
    public int getNumeroGuess(){
        return this.numeroGuess;
    }


    public int getTotalIntentos(){
        return this.intentos.size();
    }

    public String getStatus(){
        return this.status;
    }

    public int getPremio(){
        return this.premio;
    }
    /**
     * Verifica algo :v
     * @param sIntento
     * @return
     */
    public boolean guess(int intento){
        boolean result = false;
        if (this.numeroGuess == intento) result = true;
        if(!result) failGuess(intento);
        else assertGuess();
        
        return result;
    }

    private void failGuess(int intento){
        this.premio -= this.disminucion; 
        this.intentos.add(intento);
    }

    private void assertGuess(){
        this.status = "Ganado";
    }

    /**
     * Reinicia el juego
     */
    public void restart(int num){
        this.init();
    }

}