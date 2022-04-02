package net.yoedtos.pwgen.service;

public class ServiceFactory {

	private static ServiceFactory instance;
	
	private ServiceFactory() {}
	
	public static ServiceFactory getInstance() {
		if(instance == null) {
			instance = new ServiceFactory();
		}
		return instance;
	}
	
	public GeneratorService getGeneratorService() {
		GeneratorService service = new GeneratorService();
		return service;
	}
}
