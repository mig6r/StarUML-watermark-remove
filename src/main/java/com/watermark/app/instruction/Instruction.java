package com.watermark.app.instruction;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.watermark.app.builders.Builder;
import com.watermark.app.loggers.Logger;
import com.watermark.app.models.FileModel;

public class Instruction {

	public Instruction() {
	}

	public void unmarkFile() throws IOException, TransformerException {
		Scanner scanner = new Scanner(System.in);
		FileModel file = new FileModel();
		Logger logger = new Logger();

		
		logger.info("Give the file name:");
		file.setName(scanner.next());
		try {
			Builder builder = new Builder(file.getName());
			NodeList textNodes = builder.getDocument().getElementsByTagName("text");
			List<Node> markedNodes = new ArrayList<Node>();
			for (int i = 0; i < textNodes.getLength(); i++) {

				if (textNodes.item(i).getTextContent().contentEquals("UNREGISTERED")) {
					markedNodes.add(textNodes.item(i));
				}
			}
			for (Node nodeToDelete : markedNodes) {
				nodeToDelete.getParentNode().removeChild(nodeToDelete);
			}

			DOMSource source = new DOMSource(builder.getDocument());

			FileWriter writer = new FileWriter(new File("unmarked_" + file.getName()));
			StreamResult result = new StreamResult(writer);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(source, result);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}

	public void unmarkFolder() throws IOException, TransformerException {

		
		File folder = new File("./");
		File[] listOfFiles = folder.listFiles();
	
		for (int i = 0; i < listOfFiles.length; i++) {

			int a = listOfFiles[i].getName().lastIndexOf('.');
			if (a > 0) {
			  String  extension = listOfFiles[i].getName().substring(a+1);
			  if (extension.contains("svg")) {
				  
				  
				  
				  FileModel file = new FileModel();
				  file.setName(listOfFiles[i].getName());
				  
				  try {
						Builder builder = new Builder(file.getName());
						NodeList textNodes = builder.getDocument().getElementsByTagName("text");
						List<Node> markedNodes = new ArrayList<Node>();
						for (int b = 0; b < textNodes.getLength(); b++) {

							if (textNodes.item(b).getTextContent().contentEquals("UNREGISTERED")) {
								markedNodes.add(textNodes.item(b));
							}
						}
						for (Node nodeToDelete : markedNodes) {
							nodeToDelete.getParentNode().removeChild(nodeToDelete);
						}

						DOMSource source = new DOMSource(builder.getDocument());

						FileWriter writer = new FileWriter(new File("unmarked_" + file.getName()));
						StreamResult result = new StreamResult(writer);

						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer = transformerFactory.newTransformer();
						transformer.transform(source, result);

					} catch (RuntimeException e) {
						System.out.println(e.getMessage());
				  
					}
				  
			  }
			  
			}		
		}

	}
}
