package prolab2_3;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author BerkayEfe
 */
public class OturumKontolcusu {

    final static String dosyaIsmi = "oturumKontrolu.conf";

    public static void  kullaniciEmailYaz(String email) {

        String temp = email;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaIsmi))) {

            writer.write(temp);

        } catch (IOException ex) {
            System.out.println("write fonksiyonunda dosya açılırken hata oldu.");
        }
    }
    private static void dosyayaYaz(String metin){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaIsmi))) {

            writer.write(metin);

        } catch (IOException ex) {
            System.out.println("write fonksiyonunda dosya açılırken hata oldu.");
        }
    }
    public static void cikisYap() {        
        dosyayaYaz("-");
    }
    public static String kullaniciEmailOku() {
        oturumDosyasiVarlikKontroluYap();
        String bilgiler = "";
        int index =0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(dosyaIsmi)))) {
            while (scanner.hasNext()) {
                bilgiler =  scanner.nextLine();
            }
        
        } catch (FileNotFoundException ex) {
            System.out.println("dosya okunamadi");
            //return new String[3];// bos index donuluyor.
        }
        
        return bilgiler ; // bos index donuluyor. 
    }

    private static  void oturumDosyasiVarlikKontroluYap() {
        // oturum dosyasinin olup olmadigini kontrol eder.
        try {
            FileReader file = new FileReader(dosyaIsmi);
        } catch (FileNotFoundException ex) {
            dosyayaYaz("-"); // eger dosya yoksa dosya olusturulup - atanir.
            
        }
       
    }

}
