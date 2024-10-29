/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Scanner;

/**
 *
 * @author Graziani
 */
public class Lotteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Scelta del numero dei numeri da estrarre
        Scanner scanner = new Scanner(System.in); // Creazione dello scanner
        System.out.print("Dimensione della matrice da estrarre (x * 5): ");
        int n = scanner.nextInt(); // Lettura del numero intero
        
        // Istanza ed avvio del thread Estrazione
        Estrazione estrazione = new Estrazione(n);
        
        // Istanza di alcuni thread Giocatore
        Giocatore g1 = new Giocatore(1, "Alunni", estrazione);
        Giocatore g2 = new Giocatore(2, "Sbiccio", estrazione);
        Giocatore g3 = new Giocatore(3, "Giosue", estrazione);
        
        // Avvio dei thread Giocatori
        g1.start();
        g2.start();
        g3.start();
        
        // Attesa della fine dei thread Giocatori
        try {
            g1.join(); // Aspetta che g1 termini
            g2.join(); // Aspetta che g2 termini
            g3.join(); // Aspetta che g3 termini
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        estrazione.start(); //Una volta finiti i giocatori

        // Attesa della fine del thread Estrazione
        try {
            estrazione.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
   