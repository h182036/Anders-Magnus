package no.hvl.dat102.adt;

import no.hvl.dat102.CD;
import no.hvl.dat102.Sjanger;

public interface CDarkivADT {

    CD[] hentCdTabell(); //Henter ut alle cder i arkivet

    void leggTil(CD cd); //Legger til en cd i arkivet

    void slettCD(int id); //Sletter en cd fra arkivet

    CD[] finnCD(String delstreng); //Finner alle cder med en gitt streng i tittelen

    CD[] finnArtist(String delstreng); //Finner cder laget av gitt artist som søkes som streng

    int antallCD(); //Henter ut antall cder i arkivet

    int hentAntall(Sjanger sjanger); //Henter ut antall cder meg gitt sjanger
	}
