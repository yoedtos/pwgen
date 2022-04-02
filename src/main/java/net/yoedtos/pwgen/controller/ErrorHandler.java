package net.yoedtos.pwgen.controller;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "errorHandler")
@RequestScoped
public class ErrorHandler {

	private Map<String, Object> requestMap;
	
	@PostConstruct
	public void createMapRequest() {
		requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
	}
	
	public Integer getStatusCode() {
		return get("javax.servlet.error.status_code", Integer.class);
	}
	
	public String getMessage() {
		return get("javax.servlet.error.message");
	}
	
	public String getExceptionClassName() {
		return get("javax.servlet.error.exception", Exception.class).getClass().getName();
	}
	
	public String getRequestURI() {
		return get("javax.servlet.error.request_uri");
	}
	
	@SuppressWarnings("unchecked")
	private <T> T get(String key, Class<T> clazz) {
		return (T) requestMap.get(key);
	}
	
	private String get(String key) {
		return get(key, String.class);
	}
}
