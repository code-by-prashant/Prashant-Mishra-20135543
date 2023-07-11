package com;

import java.util.ArrayList;

public class Employee {
	ArrayList<Integer> empId = new ArrayList<Integer>();
	ArrayList<String> empName = new ArrayList<String>();
	ArrayList<String> progLang  = new ArrayList<String>();

	
	public ArrayList<String> getProgLang() {
		return progLang;
	}
	public void setProgLang(ArrayList<String> progLang) {
		this.progLang = progLang;
	}
	public ArrayList<Integer> getEmpId() {
		return empId;
	}
	public void setEmpId(ArrayList<Integer> empId) {
		this.empId = empId;
	}
	public ArrayList<String> getEmpName() {
		return empName;
	}
	public void setEmpName(ArrayList<String> empName) {
		this.empName = empName;
	}
	
	void display() {
		 System.out.println("Employee Details:\n");
	               
	        System.out.println("Employee IDs: ");
	        
	        for (Object id : empId) {
	            System.out.println("- " + id);
	        }
	        System.out.println("");
	        
	        System.out.println("Employee Names: ");
	        
	        for (String name : empName) {
	            System.out.println("- " + name);
	        }
	        
	        System.out.println("");

	        System.out.println("Programming languages opted for: ");
	        
	        for (String lang : progLang) {
	            System.out.println("- " + lang);
	        }
	}
	
}
