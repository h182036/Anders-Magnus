package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

import java.util.Scanner;

public class TekstGrensesnitt {

    private Scanner sc = new Scanner(System.in);

    public CD lesCD(){
        System.out.println("IDen til CDen: ");
        int cdnummer = sc.nextInt();
        sc.nextLine();
        System.out.println("Navn på Artist: ");
        String navn = sc.nextLine();
        System.out.println("Tittel: ");
        String tittel = sc.nextLine();
        System.out.println("Lanseringsår: ");
        int år = sc.nextInt();
        sc.nextLine();
        System.out.println("Velg en sjanger:");
        System.out.println("1) POP");
        System.out.println("2) ROCK");
        System.out.println("3) OPERA");
        System.out.println("4) Jazz");
        System.out.println("5) KLASSISK");
        int valg = sc.nextInt();
        sc.nextLine();
        Sjanger sjanger = Sjanger.KLASSISK;
        if (valg == 1){
            sjanger = Sjanger.POP;
        }else if(valg == 2){
            sjanger = Sjanger.ROCK;
        }else if(valg == 3){
            sjanger = Sjanger.OPERA;
        }else if (valg == 4){
            sjanger = Sjanger.JAZZ;
        }else if (valg == 5) {
        	sjanger = Sjanger.KLASSISK;
        }
        System.out.println("Plateselskap: ");
        String plateselskap = sc.nextLine();
        return new CD(cdnummer, navn, tittel, år, sjanger, plateselskap);
    }

    private void visCD(CD cd){
        System.out.println("Cdnummer: " + cd.getCdnummer());
        System.out.println("Artist " + cd.getArtist());
        System.out.println("Tittel: " + cd.getTittel());
        System.out.println("Lansert " + cd.getÅr());
        System.out.println("Sjanger: " + cd.getSjanger().toString());
        System.out.println("Plateselskap: " + cd.getPlateselskap());
        System.out.println();
    }

    public void skrivUtCdDelstrengTittel(CDarkivADT cda, String delstreng){
        CD[]cd = cda.finnCD(delstreng);
        for (CD c:cd) {
            visCD(c);
        }
    }

    public void skrivUtCdArtist(CDarkivADT cda, String delstreng){
        CD[]cd = cda.finnArtist(delstreng);
        for(CD c : cd){
            visCD(c);
        }
    }

    public void skrivUtStatistikk(CDarkivADT cda){
        int antallCD = cda.antallCD();
        System.out.println("Det er " + antallCD + " plate/plater på lageret");
        for (Sjanger s : Sjanger.values()){
            int tall = cda.hentAntall(s);
            System.out.println("Det er " + tall + " plater under sjangeren " + s.toString());
        }
    }
}