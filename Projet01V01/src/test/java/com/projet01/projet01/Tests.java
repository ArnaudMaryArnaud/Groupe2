package com.projet01.projet01;

import metier.InterfaceMetier;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import Entities.Employe;

public class Tests {

	public static void main(String[] args) {
	
		 ClassPathXmlApplicationContext context= 
				 
				 new ClassPathXmlApplicationContext( new String []{"app.xml"});
                InterfaceMetier metier=(InterfaceMetier) context.getBean("metier");
                
                metier.addemploye(new Employe("aa"));


	}

}
