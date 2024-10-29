/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;

/**
 *
 * @author Graziani
 */
public class Estrazione extends Thread {
    // attributi
    private int[][] matriceNumeri;
    int n;
    private int[] vincitori;
    int numeroVincitori = 0;
    
    /**
     * 
     * Metodo costruttore
     */   
    public Estrazione(int n) {
        this.n = n;
        this.matriceNumeri = new int[5][n];
        this.vincitori = new int[3];

        // Popolamento matrice numeri con numeri casuali da 1 a 100
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                matriceNumeri[i][j] = random.nextInt(90) + 1;
            }
        }
        // inizializzazione array vincitori
    }

    /**
    * 
    * Metodo per visualizzare la matrice dei numeri estratti
    */
    public void stampaMatrice() {
       // stampa matrice dei numeri estratti
       System.out.println("Numeri estratti:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriceNumeri[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
    * 
    * Metodo per visualizzare i vincitori dell'estrazione
    */
    public void stampaVincitori() {
        // stampa array dei vincitori
        if(numeroVincitori > 0){
            System.out.println("Giocatori vincitori:");
            for (int i = 0; i < numeroVincitori; i++) {
                System.out.println("\u001B[32mGiocatore " + vincitori[i] + " ha vinto!\u001B[0m");
            }
        }
        else{
            System.out.println("\u001B[31mNessun vincitore\u001B[0m");
        }
        
    }

    /**
    * 
    * Metodo per verificare il numero scelto dal giocatore e determinare i vincitori
    */
    public void verifica(int numero, int idGiocatore) {
        boolean trovato = false;
        
        // Controllo se il numero scelto dal giocatore è nella matrice dei numeri estratti
        for (int i = 0; i < 5 && !trovato; i++) {
            for (int j = 0; j < n && !trovato; j++) {
                if (matriceNumeri[i][j] == numero) {
                    trovato = true;
                    vincitori[numeroVincitori] = idGiocatore;
                    numeroVincitori++;
                }
            }
        }
    }

    /**
    * 
    * Metodo per eseguire il thread
    */
    public void run() {
        
        // stampa matrice
        stampaMatrice();
       
        // stampa finale
        stampaVincitori();
        
         
    }
}