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
public class Oving12Encodingv2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pathInn = "C:\\Users\\Balder\\Desktop\\Skole\\Algoritmer og Datastrukturer\\oving12Encodingv2\\src\\oving12encodingv2\\testInn.txt";
        String pathUt = "C:\\Users\\Balder\\Desktop\\Skole\\Algoritmer og Datastrukturer\\oving12Encodingv2\\src\\oving12encodingv2\\Ut.txt";
        FilLeser fl = new FilLeser(pathInn);
        FilSkriver fs = new FilSkriver(pathUt);
        Encoder encoder = new Encoder(fl, fs, 256, 4096);
        encoder.komprimer();
        fs.lukk();
    }
    
}
