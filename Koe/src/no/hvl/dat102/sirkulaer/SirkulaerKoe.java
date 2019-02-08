package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class SirkulaerKoe<T> implements KoeADT<T> {
		private static final int STD = 100;
		private int front, bak, antall;	
		private T[] koe;
		
		
		public SirkulaerKoe (int STD ) {
			front = bak = antall = 0;
			koe = (T[]) (new Object[STD]);
		}
		
		
		
		public void utvid() {
			T[] hjelpetabell = (T[])(new Object[koe.length*2]);
			for(int soek = 0; soek < antall; soek++) {
				hjelpetabell[soek]=koe[front];
				front = (front+1) % koe.length;
				
			}
			front = 0;
			bak = antall;
			koe = hjelpetabell;
		}
		@Override
		public void innKoe(T element) {
			if(antall() == koe.length) {
				utvid();
			}
			koe[bak] = element;
			bak = (bak+1)%koe.length;
			antall++;
			// TODO Auto-generated method stub
			
		}
		@Override
		public T utKoe() {
			if(erTom())
				throw new EmptyCollectionException("Koe");
				
			T resultat = koe[front];
			koe[front] = null;
			front = (front+1)%koe.length;
			antall--;
			// TODO Auto-generated method stub
			return resultat;
		}
		@Override
		public T foerste() {
			T resultat = null;
			if(!erTom()) {
				resultat = koe[0];
			}
			// TODO Auto-generated method stub
			return resultat;
		}
		@Override
		public boolean erTom() {
			return (antall == 0);
			// TODO Auto-generated method stub
			
		}
		@Override
		public int antall() {
			// TODO Auto-generated method stub
			return antall;
		}
		
}
