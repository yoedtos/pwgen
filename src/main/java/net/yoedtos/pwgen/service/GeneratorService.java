package net.yoedtos.pwgen.service;

import static net.yoedtos.pwgen.core.model.Symbols.*;
import java.util.ArrayList;
import java.util.List;

import net.yoedtos.pwgen.core.Shuffler;
import net.yoedtos.pwgen.core.model.Demand;

public class GeneratorService {

	private List<char[]> sequence = new ArrayList<>();
	private Shuffler shuffler; 
	
	public List<String> generate(Demand demand) {
		
		shuffler = new Shuffler(demand.getSeed());
		
		switch (demand.getAlgorithm()) {
			case "Pr":
				int size = demand.getSymbols().length + 1;
				String[] symbolSet = new String[size];
				symbolSet[0] = "v";
				System.arraycopy(demand.getSymbols(), 0, symbolSet, 1, size - 1);
				createPronouceable(symbolSet, demand.getMaxValue());
				break;
			case "Rd":
				createRandom(demand.getSymbols(), demand.getMaxValue());
				break;
			default:
				break;
			}
		
		return shuffler.getGenerated(sequence, demand.getAmount());
	}
	
	private void createPronouceable(String[] symbols, int size) {
		String[] symbolSet = shuffler.createSymbolsSetArray(symbols, size);
		
		int counter = 0;
		while (counter < symbolSet.length) {
			if(symbolSet[counter].contains("s")) {
				sequence.add(consonant);
				sequence.add(vowel);
				counter++;
			} else if (symbolSet[counter].contains("C")) {
				sequence.add(CONSONANT);
				sequence.add(VOWEL);
				counter++;
			} else if (symbolSet[counter].contains("N")) {
				sequence.add(NUMBERS);
			} else if (symbolSet[counter].contains("S")) {
				sequence.add(SYMBOLS);
			} else if (symbolSet[counter].contains("v")) {
				sequence.add(CONSONANT);
				sequence.add(vowel);
				counter++;
			} 
			counter++;
		}
	}
	
	private void createRandom(String[] symbols, int size) {
		String[] symbolSet = shuffler.createSymbolsSetArray(symbols, size);
		for (int i = 0; i < symbolSet.length; i++) {
			if(symbolSet[i].contains("s")) {
				sequence.add(alphabet);
			} else if (symbolSet[i].contains("C")) {
				sequence.add(ALPHABET);
			} else if (symbolSet[i].contains("N")) {
				sequence.add(NUMBERS);
			} else if (symbolSet[i].contains("S")) {
				sequence.add(SYMBOLS);
			}
		}
	}
}
