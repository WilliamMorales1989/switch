package com.ec.tvcable.switch_aprov.switchy_aprovisionamiento.test;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class BaseTest {

	private final String TEST_RESOURCE_PATH = "src/test/resources/";
	
	protected Document loadDocumentXML(String path) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		return db.parse(getClass().getClassLoader().getResourceAsStream(path));
	}

	protected String loadStringXML(String path) throws Exception {
		String content = new Scanner(new File(TEST_RESOURCE_PATH + path)).useDelimiter("\\Z")
				.next();
		return content;
	}

}
