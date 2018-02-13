package com.banking.json;

import java.util.ArrayList;
import java.util.List;

public class Paging {
	ArrayList<Document> documents = null;
			
	public Paging(ArrayList<Document> documents) {
		this.documents = documents;

	}
	
	public int getEndIndex(int startIndex, int pageSize) {
		int endIndex = startIndex + pageSize - 1;
		
		if(endIndex > this.documents.size()){
			endIndex = this.documents.size();
		}
		
		return endIndex;
	}

	public int getStartIndex(int givenPage, int pageSize) throws Exception {
		int startIndex = (givenPage - 1) * pageSize + 1;

        if(startIndex > this.documents.size()){
        	throw new Exception("Start index out of bounds");
        }
        
        return startIndex;
	}

	public List<Document> getPagedDocuments(int givenPage, int pageSize) throws Exception {
		int startIndex = getStartIndex(givenPage, pageSize);
		int endIndex = getEndIndex(startIndex, pageSize);
		return this.documents.subList(startIndex -1, endIndex);
	}

	public int getNextPage(int givenPage, int pageSize) {
		if (givenPage * pageSize + 1 <= this.documents.size())
			return givenPage + 1;
		else
			return -1;
	}

	public int getPreviousPage(int givenPage, List<Document> pagedDocuments) {
		if(pagedDocuments.size() > 0 && givenPage >= 2)
			return givenPage -1;
		else
			return -1;
	}

	
}
