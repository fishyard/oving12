/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oving12decodingv2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Balder
 */
public class FilLeser {
    private String filnavn;
    private BufferedReader br;
    private FileReader fr;
    
    public FilLeser(String filnavn){
        this.filnavn = filnavn;
        try{
        this.fr = new FileReader(new File(filnavn));
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        this.br = new BufferedReader(fr);
    }
    
    public String lesEnLinje(){
        try {
            //fr = new FileReader(filnavn);
            //br = new BufferedReader(fr);
            String streng;
            streng = br.readLine();
            //System.out.println("Streng: " + streng);
            return streng;
        } catch (IOException e) {
            System.out.println("Feil i lesEnLinje");
            e.printStackTrace();
        } /*finally {
            try {
                if (br != null){
                    br.close();
                    System.out.println("br stengt");
                }
                if (fr != null){
                    fr.close();
                    System.out.println("fr steng");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }*/
        //System.out.println("For en meme");
        return null;
    }
    
    public String[] lesLinje(){
        String[] stringArr = new String[finnStorrelseLinje()];
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(filnavn);
            br = new BufferedReader(fr);
            String streng;
            int i = 0;
            while ((streng = br.readLine()) != null) {
                stringArr[i] = streng;
                i++;
            }
            return stringArr;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    public String[][] lesFilWord(int ordPerLinje){
        String[][] ordArr = new String[finnStorrelse()][ordPerLinje];
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(filnavn);
            br = new BufferedReader(fr);
            String linje;
            int i = 0;
            while ((linje = br.readLine()) != null) {
                String ord[] = linje.split(" ");
                for(int n = 0; n < ord.length; n++){
                    ordArr[i][n] = ord[n];
                }
                i++;
            }
            return ordArr;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    public int[] lesFilKarakterInt(){
        int[] intArr = new int[finnStorrelse()];
        System.out.println("intArr lengde: " + intArr.length);
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(filnavn);
            br = new BufferedReader(fr);
            int heltall;
            int i = 0;
            while ((heltall = br.read()) != -1) {
                //System.out.println(heltall);
                intArr[i] = heltall;
                i++;
            }
            return intArr;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    public void reset(){
        try{
            br.reset();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public int finnStorrelse(){
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(filnavn);
            br = new BufferedReader(fr);
            int i = 0;
            while (br.read() != -1) {
                i++;
            }
            return i;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }
    
    public int finnStorrelseLinje(){
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(filnavn);
            br = new BufferedReader(fr);
            int i = 0;
            while (br.readLine() != null) {
                i++;
            }
            return i;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }
}
