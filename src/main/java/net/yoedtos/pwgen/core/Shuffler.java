package net.yoedtos.pwgen.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shuffler {
	
	private Random random;
	private StringBuilder builder = new StringBuilder();
	
	public Shuffler(Long seed) {
		this.random = new Random();
		if(seed > 0) {
			random.setSeed(seed);
		}
	}
	
	public List<String> getGenerated(List<char[]> listArray, int amount) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			list.add(shuffle(listArray));
		}
		return list;
	}
	
	public String[] createSymbolsSetArray(String[] symbols, int size) {
		String[] array = new String[size];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = symbols[random.nextInt(symbols.length)];
		}
		return array;
	}
	
	private String shuffle(List<char[]> listArray) {
		builder.setLength(0);
		for (char[] chars : listArray) {
			builder.append(chars[random.nextInt(chars.length)]);
		}
		return builder.toString();
	}
}
