package com.java.xml.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.java.xml.sii.Fea;


@XmlRootElement(namespace = "resolucion")
public class Resolucion {

	
	
	@XmlElement(name = "encabezado")
	private Fea fe;

	public Fea getFea() {
		return fe;
	}

	public void setFea(Fea fe) {
		this.fe = fe;
	}
	
	
	
	
	
}
