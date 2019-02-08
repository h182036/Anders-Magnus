package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

		public class KjedetKoe<T extends Comparable <T>> 
			implements KoeADT<T> {
			private int antall;
			private LinearNode<T> start, slutt;
			
		public KjedetKoe() {
			
			antall = 0;
			start = slutt = null;
		}
		@Override
		public void innKoe (T element) {
			LinearNode<T> koe = new LinearNode<T>(element);
			
			if(erTom())
			start = koe;
			else 
				slutt.setNeste(koe);
			
			slutt = koe;
			antall++;
		}
		@Override
		public T utKoe() throws EmptyCollectionException {
			if(erTom())
				throw new EmptyCollectionException("Koe");
				
			T resultat = start.getElement();
			start = start.getNeste();
			antall--;
			
			if(erTom())
				slutt = null;
			return resultat;
		}
		@Override
		public T foerste() {
			if (erTom())
				throw new EmptyCollectionException("kø");

			T resultat = start.getElement();
			return resultat;
		}
		@Override
		public boolean erTom() {
			return (antall == 0);
			// TODO Auto-generated method stub
		}
		@Override
		public int antall() {
			return antall;
			// TODO Auto-generated method stub
			
		}
}	
		