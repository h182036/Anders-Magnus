package no.hvl.dat102;

import no.hvl.dat102.adt.CDarkivADT;

public class CDarkivklient {
    
	public static void main(String[] args){
        CDarkivADT cda2 = new CDarkiv2();
        Meny meny = new Meny(cda2);
        meny.start();
    }
}