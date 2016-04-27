package com.projet01.projet01;

import static org.junit.Assert.*;

import java.util.Date;

import metier.InterfaceMetier;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Entities.Clients;

public class TestTestV1 {

	private static ClassPathXmlApplicationContext context;
	private static InterfaceMetier metiereEmpl;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		metiereEmpl=(InterfaceMetier)context.getBean("metier");
		metiereEmpl.addclient(new Clients("", "prenomClient", new Date(),"dd"));
	}

}
