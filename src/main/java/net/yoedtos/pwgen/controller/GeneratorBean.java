package net.yoedtos.pwgen.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import net.yoedtos.pwgen.core.model.Demand;
import net.yoedtos.pwgen.service.GeneratorService;
import net.yoedtos.pwgen.service.ServiceFactory;

import java.io.Serializable;
import java.util.List;

@ManagedBean(name="generator")
@ViewScoped
public class GeneratorBean implements Serializable {

	private static final long serialVersionUID = -5630518150048960676L;

	private String algorithm;
	private String[] symbols;
	private Integer amount;
	private Integer minValue = 5;
	private Integer maxValue;
	private Long seed = 0L;
	
	private List<String> listPasswords;
	
	public String doIt() {
		GeneratorService service = ServiceFactory.getInstance().getGeneratorService();
		listPasswords = service.generate(new Demand(algorithm, symbols, amount, minValue, maxValue, seed));
		return null;
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
	
	public List<String> getListPasswords() {
		return listPasswords;
	}

	public void setListPasswords(List<String> listPasswords) {
		this.listPasswords = listPasswords;
	}

}
