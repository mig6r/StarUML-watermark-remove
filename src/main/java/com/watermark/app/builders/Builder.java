package com.watermark.app.builders;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.watermark.app.loggers.Logger;

public class Builder {

	private Document document;

	public Builder(String fileName) throws RuntimeException {
Logger logger = new Logger();
		try {

			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(fileName));
		} catch (Throwable e) {
			//throw new RuntimeException("Enable to read " + fileName);
			logger.error("Enable to read " + fileName);
		}
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}
