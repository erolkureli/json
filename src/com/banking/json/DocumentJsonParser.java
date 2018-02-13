package com.banking.json;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DocumentJsonParser {
	private FileReader fileReader;

	public DocumentJsonParser(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public ArrayList<Document> getDocuments() throws IOException, ParseException {
		ArrayList<Document> documents = parseJson();
		return documents;
	}
	
	public ArrayList<Document> parseJson() throws IOException, ParseException {
		ArrayList<Document> documents = new ArrayList<Document>();

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(this.fileReader);
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray solutions = (JSONArray) jsonObject.get("results");
		Iterator<?> iterator = solutions.iterator();

		while (iterator.hasNext()) {
			JSONObject innerObj = (JSONObject) iterator.next();
			System.out.println("href " + innerObj.get("href") + " title " + innerObj.get("title") + " summary "
					+ innerObj.get("summary"));
			Document document = new Document();
			document.setHref(innerObj.get("href").toString());
			document.setTitle(innerObj.get("title").toString());
			document.setSummary(innerObj.get("summary").toString());
			documents.add(document);
		}

		return documents;
	}
}
