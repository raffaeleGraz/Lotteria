/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Graziani
 */
public class Giocatore extends Thread{
    // attributi
    int idGiocatore;
    String nomeGiocatore;
    Estrazione estrazione; 
    private static final Scanner scanner = new Scanner(System.in); // Scanner condiviso

    /**
    * 
    * Metodo costruttore
    * @param idGiocatore codice del giocatore
    * @param estrazione riferimento dell'oggetto Estrazione
    */
    public Giocatore(int idGiocatore, String nomeGiocatore, Estrazione estrazione) {
       // inizializzazione attributi
       this.idGiocatore = idGiocatore;
       this.nomeGiocatore = nomeGiocatore;
       this.estrazione = estrazione;
    }

    /**
    * 
    * Metodo per eseguire il thread
    */
    public void run() {
        
         synchronized (scanner) { // Sincronizzazione sull'input
            System.out.print("Giocatore " + idGiocatore + " scegli un numero: ");
            int numeroScelto = scanner.nextInt(); // Numero in input

            // Verifica del risultato
            estrazione.verifica(numeroScelto, idGiocatore);
        }
        
    }
}