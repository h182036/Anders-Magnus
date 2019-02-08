package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

public class CDarkiv implements CDarkivADT {
    private CD[] arkiv;
    private int antall;

    public CDarkiv(int plasser){
    	arkiv = new CD[plasser];
        antall = 0;
    }

    @Override
    public CD[] hentCdTabell() {
        return arkiv;
    }

    private int finnCD(int id){
       for (int i = 0; i < antall; i++){
           if(arkiv[i].getCdnummer() == id){
               return i;
           }
       }
       return -1;
    }


    private void utvidKapasitet(){
        CD[] hjelpetabell = new CD[(int)Math.ceil(1.1 * arkiv.length)];
        for (int i = 0; i < arkiv.length; i++){
            hjelpetabell[i] = arkiv[i];
        }
        arkiv = hjelpetabell;
    }

    @Override
    public void leggTil(CD cd) {
        int plass = finnCD(cd.getCdnummer());
        if (plass >= 0){
            System.out.println("CD-en fantes fra før av, så den ble ikke lagt til");
        }
        else {
            if (antall == arkiv.length){
                System.out.println("Utvider kapasiteten..");
                utvidKapasitet();
            }
            System.out.println("Legger til platen: " + cd.getTittel());
            arkiv[antall] = cd;
            antall++;
        }
    }

    @Override
    public void slettCD(int id) {
        int plass = finnCD(id);
        if (plass < 0){
            System.out.println("Fant ikke CD-en, så slettet ikke noe");
        }
        else {
        	arkiv[plass] = arkiv[antall - 1];
        	arkiv[antall - 1] = null;
            antall--;
        }

    }

    private int finnAntall(int valg, String delstreng){
        int teller = 0;
        if (valg == 1){
            for (int i = 0; i < antall; i++){
                if (arkiv[i].getTittel().contains(delstreng)){
                    teller++;
                }
            }
            return teller;
        }else {
            for (int i = 0; i < antall; i++){
                if (arkiv[i].getArtist().contains(delstreng)){
                    teller++;
                }
            }
            return teller;
        }
    }

    @Override
    public CD[] finnCD(String delstreng) {
        int mengde = finnAntall(1, delstreng);

        CD[] tittelCD = new CD[mengde];
        int teller = 0;
        for (int i = 0; i < antall; i++){
            if (arkiv[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())){
                tittelCD[teller] = arkiv[i];
                teller++;
            }
        }
        return tittelCD;
    }

    @Override
    public CD[] finnArtist(String delstreng) {
        int mengde = finnAntall(2, delstreng);

        CD[] artistCD = new CD[mengde];
        int teller = 0;
        for (int i = 0; i < antall; i++){
            if (arkiv[i].getArtist().toLowerCase().contains(delstreng.toLowerCase())){
                artistCD[teller] = arkiv[i];
                teller++;
            }
        }
        return artistCD;
    }

    @Override
    public int antallCD() {
        return antall;
    }

    @Override
    public int hentAntall(Sjanger sjanger) {
        int teller = 0;
        for (CD c : arkiv){
            if (c == null){
            }
            else if (c.getSjanger() == sjanger){
                teller++;
            }
        }
        return teller;
    }

}