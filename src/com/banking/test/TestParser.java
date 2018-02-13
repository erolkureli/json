package com.banking.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import com.banking.json.Document;
import com.banking.json.DocumentJsonParser;
import com.banking.json.Paging;

public class TestParser {
	@Test
	public void testPaging() throws IOException, ParseException {
		DocumentJsonParser mockdocumentJsonParser = mock(DocumentJsonParser.class);
		
		Document document = new Document();
		document.setHref("https://link/to/result");
		document.setSummary("Document summary");
		document.setTitle("Document title");
		ArrayList<Document>testList = new ArrayList<Document>();
		testList.add(document);
		//PagingProcess mockProcess = mock(PagingProcess.class);
		when(mockdocumentJsonParser.getDocuments()).thenReturn(testList);
		Paging paging = new Paging(mockdocumentJsonParser.getDocuments());
		
		Assert.assertEquals(paging.getNextPage(1, 1), -1);
	}
}
