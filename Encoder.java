/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oving12encodingv2;

/**
 *
 * @author Balder
 */
public class Encoder {
    private FilLeser fl;
    private FilSkriver fs;
    private int antKarakterer;
    private int maxKoder;
    private String[] ordBok;
    private int index;
    
    public Encoder(FilLeser fl, FilSkriver fs, int antKarakterer, int maxKoder){
        this.fl = fl;
        this.fs = fs;
        this.antKarakterer = antKarakterer;
        this.index = antKarakterer;
        this.maxKoder = maxKoder;
    }
    
    public void komprimer(){
        String[]linjeInn = fl.lesLinje();
        char[] charInn = {'b', 'a', 'n', 'a', 'n', 'a', ' ', 'b', 'a', 'n', 'd', 'a', 'n', 'a'}; //test verdier, hele filen skal leses og gjøres om til et char array
        //Initializerer "ordboka"
        ordBok = new String[maxKoder];
        for(int i = 0; i < antKarakterer; i++){
            ordBok[i] = Character.toString((char)i);
        }
        String s = "";
        for(int i = 0; i < charInn.length; i++){
            s = s.concat(Character.toString(charInn[i]));
            int k;
            if((k = finnesIOrdBok(s)) != -1 ){
                System.out.println("'"+ s + "' finnes i ordboka");
                //fs.skriv(k);
                //s = s.concat(Character.toString(charInn[i+1]));
            }else{
                System.out.println("Legger '" + s + "' i ordboka");
                leggIOrdBok(s);
                s = s.substring(s.length() - 1);
            }
        }
        
    }
    
    private int finnesIOrdBok(String s){
        //if(s.length() == 1) return true;
        if(s.length() == 1){
            for(int i = 0; i < antKarakterer; i++){
                if(s.equals(ordBok[i])){
                    //fs.skriv(i);
                    return i;
                }
            }
        }else{
            for(int i = 0; i < maxKoder; i++){
                if(s.equals(ordBok[i])){
                    //fs.skriv(i);
                    return i;
                }
            }
        }
        return -1;
    }
    
    private void leggIOrdBok(String s){
        ordBok[index] = s;
        //fs.skriv(index);
        index++;
    }
}
