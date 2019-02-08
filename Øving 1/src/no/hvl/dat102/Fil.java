package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

import java.io.*;
import java.util.Scanner;

public class Fil {

    public static void lesFraFil(CDarkivADT cdarkiv, String filnavn){
        final String skille = "#";
        try{
            FileReader fil = new FileReader(filnavn);
            Scanner sc = new Scanner(fil);
           

            while (sc.hasNextLine()){
                String linje  = sc.nextLine();
                String[] splitt = linje.split(skille);
                int cdnummer = Integer.parseInt(splitt[0]);
                String artist = splitt[1];
                String tittel = splitt[2];
                int år = Integer.parseInt(splitt[3]);
                Sjanger sjanger = Sjanger.valueOf(splitt[4]);
                String plateselskap = splitt[5];
                cdarkiv.leggTil(new CD(cdnummer, artist, tittel, år, sjanger, plateselskap));
            }

        }catch (FileNotFoundException e){
            System.out.println("Finner ikkje filen");
        }
    }

    public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn){
        final String skille = "#";
        CD[] samling = cdarkiv.hentCdTabell();

        try{
            FileWriter fil = new FileWriter(filnavn);
            PrintWriter pw = new PrintWriter(fil);
            pw.println(cdarkiv.antallCD());
            for (int i = 0; i < cdarkiv.antallCD(); i++){
                pw.print(samling[i].getCdnummer() + skille + samling[i].getArtist() + skille +
                samling[i].getTittel() + skille + samling[i].getÅr() + skille +
                samling[i].getSjanger() + skille + samling[i].getPlateselskap());
                if (i < cdarkiv.antallCD() - 1){
                    pw.println();
                }
            }
        pw.close();
        }catch (FileNotFoundException e){
            System.out.println("Noko gikk galt");
        }catch (IOException e){
            System.out.println("IO Exception");
        }
    }
}