/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oving12decodingv2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Balder
 */
public class FilSkriver {
    private String filnavn;
    BufferedWriter br;
    FileWriter fr;
    
    public FilSkriver(String filnavn){
        this.filnavn = filnavn;
        br = null;
        fr = null;
        try {
            fr = new FileWriter(filnavn);
            br = new BufferedWriter(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void skriv(int k){
        try{
            //System.out.println("Skriver: " + (char)k);
            br.write(k);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void skrivLinjeSkifte(){
        try {
            br.newLine();
        } catch (IOException ex) {
            Logger.getLogger(FilSkriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lukk(){
        try{
            br.close();
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void skrivFilFraKarakter(int[] ca){
        //System.out.println("Er i skrivFilFraKarakter");
        int antall = ca.length;
        int i = 0;
        try{
            while(i < antall){
             br.write(ca[i]);
                i++;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
