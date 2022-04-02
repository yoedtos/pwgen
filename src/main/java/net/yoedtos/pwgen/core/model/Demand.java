package net.yoedtos.pwgen.core.model;

public class Demand {

	private String algorithm;
	private String[] symbols;
	private Integer amount;
	private Integer minValue;
	private Integer maxValue;
	private Long seed;
	
	public Demand(String algorithm, String[] symbols, Integer amount, Integer minValue, Integer maxValue, Long seed) {
		this.algorithm = algorithm;
		this.symbols = symbols;
		this.amount = amount;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.seed = seed;
	}
	
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public String[] getSymbols() {
		return symbols;
	}
	public void setSymbols(String[] symbols) {
		this.symbols = symbols;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getMinValue() {
		return minValue;
	}
	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}
	public Integer getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}
	public Long getSeed() {
		return seed;
	}
	public void setSeed(Long seed) {
		this.seed = seed;
	}
}
