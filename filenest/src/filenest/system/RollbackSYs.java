package filenest.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import filenest.domain.Document;
import filenest.domain.DocumentInfo;
import filenest.util.FileIoUtil;


public class RollbackSYs {
	

	private Map<String,List<DocumentInfo>> rollBackListMap;
	private Thread autoRollBackThread;
	
	public RollbackSYs() {
		rollBackListMap = new HashMap<String,List<DocumentInfo>>();
		
		this .autoRollBackThread = new Thread(() ->{
			try {
				while(true) {
				Thread.sleep(1000*60*60);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileIoUtil.autoSaveRollBackListMap(this.rollBackListMap);
		});
		autoSave();
	}

	private void autoSave() {
		autoRollBackThread.setDaemon(true);
		autoRollBackThread.start();
	
		
	}

	public void saveRollBackList(){
		FileIoUtil.saveRollBackList(this.rollBackListMap);
	}

	
	public Collection<DocumentInfo> getLastVersionDocs(String regNumber){

		return rollBackListMap.get(regNumber);
	}


	public void addRollBackInfo(String regNumber, DocumentInfo documentInfo) {
		List<DocumentInfo> documentInfoList = rollBackListMap.get(regNumber);
		if(documentInfoList == null){
			documentInfoList = new ArrayList<>();
			rollBackListMap.put(regNumber,documentInfoList);
		}
		documentInfoList.add(documentInfo);
	}

	public DocumentInfo removeVersion(DocumentInfo removeDocs) {
		List<DocumentInfo> documentInfoList = this.rollBackListMap.get(removeDocs.getLabel().getRegNumber());
		documentInfoList.remove(removeDocs);

		if(!documentInfoList.isEmpty()){
			return documentInfoList.get(0);
		}
		return null;
	}
}
