package filenest.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import filenest.domain.Document;

public class RollbackSYs {
	
	private Map<String, List<Document>> rollbackDocs;
	private static final String ROLLBACK_PATH = "C:\\Users\\KOSA\\Desktop\\docsIO\\rollback";
	
	public RollbackSYs() {
		rollbackDocs = new HashMap<String, List<Document>>();
	}
	public void rollBackDocs(Document docs) {
		List<Document> docList = rollbackDocs.get(docs.getLabel().getRegNumber());
		if(docList == null) {
			docList = new ArrayList<Document>();
			rollbackDocs.put(docs.getLabel().getRegNumber(), docList);
		}
		docList.add(docs);
		
	}
	
	public Collection<Document> getLastVersionDocs(String regNumber){
		return rollbackDocs.get(regNumber);
	}
	public void showDocVersions(Document docs) {
		
		
	}
	public Document findVersionDocs(String regNumber, String getversions) {
		for(Document docs : getLastVersionDocs(regNumber)) {
			if(docs.getDocumentStatus().getversionName().equals(getversions)) {
				return docs;
			}
		}
		return null;
		
	}
	
	
	
	
	
}
