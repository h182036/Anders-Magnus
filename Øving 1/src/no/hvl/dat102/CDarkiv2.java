package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT{
    private int antall;
    private LinearNode<CD> start;

    public CDarkiv2(){
        antall = 0;
        start = null;
    }

    @Override
    public CD[] hentCdTabell() {
        CD[] arkiv = new CD[antall];
        LinearNode<CD> node = start;

        for (int i = 0; i < antall && node != null; i++){
            arkiv[i] = node.getElement();
            node = node.getNeste();
        }
        return arkiv;
    }

    @Override
    public void leggTil(CD cd) {
        if (antall == 0){
            start = new LinearNode<CD>(cd);
            antall++;
        } else {
            LinearNode<CD> node = start;
            LinearNode<CD> lastNode = null;
            while (node != null){
                lastNode = node;
                node = node.getNeste();
            }
            lastNode.setNeste(new LinearNode<CD>(cd));
            antall++;
        }
    }

    @Override
    public void slettCD(int nummer) {
        if (antall == 0){
            System.out.println("\nDet er ingen plater i arkivet!");
        } else {
            LinearNode<CD> node = start;
            LinearNode<CD> forigeNode = null;
            boolean slettet = false;
            for (int i = 0; node != null && !slettet; i++){
                if (node.getElement().getCdnummer() == nummer && i == 0){
                    start = node.getNeste();
                    antall--;
                    slettet = true;
                } 
                else if (node.getElement().getCdnummer() == nummer){
                    forigeNode.setNeste(node.getNeste());
                    antall--;
                    slettet = true;
                }
                forigeNode = node;
                node = node.getNeste();
            }
            if (!slettet){
                System.out.println("\n Fant ikkje filen du ville slette på lageret\n");
            } else {
                System.out.println("\n Slettet CDen med nummer " + nummer + " fra arkivet\n");
            }
        }

    }

    @Override
    public CD[] finnCD(String delstreng) {
        CD[] tempArkiv = new CD[antall];
        int teller = 0;
        LinearNode<CD> node = start;
        while (node != null){
            if (node.getElement().getTittel().toLowerCase().contains(delstreng.toLowerCase())){
                tempArkiv[teller] = node.getElement();
                teller++;
            }
        node = node.getNeste();
        }
        System.out.println("\nFant " + teller + " plate(er) som matchet søket!\n");
        CD[] arkiv = new CD[teller];
        System.arraycopy(tempArkiv, 0, arkiv, 0, teller);
        return arkiv;
    }

    @Override
    public CD[] finnArtist(String delstreng) {
        CD[] tempArkiv = new CD[antall];
        int teller = 0;
        LinearNode<CD> node = start;
        while (node != null){
            if (node.getElement().getArtist().toLowerCase().contains(delstreng.toLowerCase())){
                tempArkiv[teller] = node.getElement();
                teller++;
            }
            node = node.getNeste();
        }
       
        System.out.println("\nFant " + teller + " plate(er) som matchet søket!\n");
        CD[] arkiv = new CD[teller];
        System.arraycopy(tempArkiv, 0, arkiv, 0, teller);
        return arkiv;
    }

    @Override
    public int antallCD() {
        return antall;
    }

    @Override
    public int hentAntall(Sjanger sjanger) {
        int teller = 0;
        if (antall != 0){
            LinearNode<CD> node = start;
            while (node != null){
            	if (node.getElement().getSjanger() == sjanger){
                    teller++;
                }
            node = node.getNeste();
            }
        }
    return teller;
    }
}