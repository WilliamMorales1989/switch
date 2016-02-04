package com.ec.tvcable.switchaprov.DatosTvpadaSGR;

public class Validacion {

	public String val (Object datoingreso, String datoalterno){
		
		String result = datoalterno;

		if (datoingreso != null) {
			
				return datoingreso.toString();
			
		}
		return result;
	}
	
	public int val (Object datoingreso, int datoalterno){
		
		int result = datoalterno;

		if (datoingreso != null) {
			
				return Integer.parseInt(datoingreso.toString());
			
		}
		return result;
	}
}
