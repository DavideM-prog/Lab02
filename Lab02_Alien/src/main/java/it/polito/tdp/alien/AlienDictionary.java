package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	private List<Word> dictionary;

	public AlienDictionary() {
		dictionary = new ArrayList<Word>();
	}
	public boolean cercaWordPresente(String alienWord, String translation) {
		Word wTemp=new Word(alienWord, translation);
		boolean trovata=false;
		for(Word w : dictionary) {
			if(w.equals(wTemp))
				trovata= true;
			else
				trovata= false;
		}
		return trovata;
	}
	public void addWord(String alienWord, String translation) {
		Word w=new Word(alienWord, translation);
		if(this.cercaWordPresente(alienWord, translation)==false)
			dictionary.add(w);
		else {
			dictionary.get(dictionary.indexOf(w)).setTranslation(translation);
		}
	}
	public String translateWord(String alienWord) {
		String s=null;
		for(Word w : dictionary) {
			if(w.getAlienWord().compareTo(alienWord)==0)
				s=w.getTranslation();
		}
		return s;
	}
	
}
