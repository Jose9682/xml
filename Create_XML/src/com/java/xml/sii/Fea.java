package com.java.xml.sii;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fea {
	private String name;
	private int age;
	
	
	
	/*Campos de SQL FEA*/
	private String DOLE_REGIONAL;
	private String DOLE_AGNO;
	
	
	
	
	
	/*******************************************************/
	
	
	
	
	public String getName() {
		return name;
	}
	public String getDOLE_REGIONAL() {
		return DOLE_REGIONAL;
	}
	public void setDOLE_REGIONAL(String dOLE_REGIONAL) {
		DOLE_REGIONAL = dOLE_REGIONAL;
	}
	public String getDOLE_AGNO() {
		return DOLE_AGNO;
	}
	public void setDOLE_AGNO(String dOLE_AGNO) {
		DOLE_AGNO = dOLE_AGNO;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
