package com.banking.json;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PagingProcess {

	public static void main(String[] args) throws Exception {
		String filePath = "C:\\json\\json.txt";
		FileReader fileReader = new FileReader(filePath);
		DocumentJsonParser documentJsonParser = new DocumentJsonParser(fileReader);
		
		ArrayList<Document> documents = null;
		int pageSize = 0;
		int givenPage = 0;
		try{
			givenPage = Integer.parseInt(args[0]);
			pageSize = Integer.parseInt(args[1]);
		}catch (Exception e) {
			pageSize = 20;
		}
		
		documents = documentJsonParser.getDocuments();
		Paging paging = new Paging(documents);
		List<Document> pagedDocuments= paging.getPagedDocuments(givenPage, pageSize);	
	    System.out.println(pagedDocuments);
	    
	    int nextPage = paging.getNextPage(givenPage, pageSize);
	    System.out.println(nextPage);
	    
	    int previousPage = paging.getPreviousPage(givenPage , pagedDocuments);
	    System.out.println(previousPage);
	}

}
