package br.com.hilix.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="StatusConverter")
public class StatusConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object status) {
		
		String statusR = "";
		
		if (status.equals(0)) statusR = "desativada";
		if (status.equals(false)) statusR = "desativada";
		
		if (status.equals(1)) statusR = "ativada";
		if (status.equals(true)) statusR = "ativada";
		
		return statusR;
	}

	

}
