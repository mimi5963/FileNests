package filenest.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import filenest.Session;
import filenest.domain.Customer;
import filenest.domain.Document;
import filenest.domain.DocumentStatus;
import filenest.domain.label.DeptCode;
import filenest.domain.label.Label;
import filenest.util.IOUtil;
import filenest.util.KeyBoardInput;

public class DocumentSys {
	private Map<String,Document> document;
	private EnumMap<DeptCode, Map<String,Document>> bookMap;
	private RollbackSYs rollbackSYs;
	private static final String path ="C:\\Users\\KOSA\\Desktop\\docsIO\\docs";
	
	public DocumentSys() {
		bookMap = new EnumMap<DeptCode, Map<String,Document>>(DeptCode.class);
		for(DeptCode code: DeptCode.values()) {
			bookMap.put(code, new HashMap<>());
		}
		document = new HashMap<>();
		this.rollbackSYs = new RollbackSYs();
	}
	
	public void addNewDocs() {
		System.out.println("********신규 문서 등록**********");
		System.out.println("문서명을 입력해주세요");
		String title = KeyBoardInput.scanner.nextLine();
		String version = title+"_v1";
		//문서 분류 지정
		System.out.println("문서 분류를 지정해주세요");
		System.out.println("1.총무부, 2.인사부, 3.경리부, 4.영업구, 5.자재부, 6.기획실, 7.전산실, 8.기타");
		int deptCode = Integer.parseInt(KeyBoardInput.scanner.nextLine());
		DeptCode code = DeptCode.getDeptCode(deptCode);
		System.out.println("문서 세부 분류를 지정해주세요");
		code.showOperationCodes();
		int opCode = Integer.parseInt(KeyBoardInput.scanner.nextLine());
		Label label = new Label(opCode, code); 
		
		//문서 상태 지정 
		System.out.println("문서 공개 여부를 입력해주세요 1.공개, 2.비공개");
		String publicinput = KeyBoardInput.scanner.nextLine();
		DocumentStatus documentStatus = null;
		if(publicinput.equals("2")) {
			System.out.print("문서 비밀번호를 입력해주세요:");
			String pass = KeyBoardInput.scanner.nextLine();
			documentStatus = DocumentStatus.documentStatusWithPassword(pass, version);
		}else {
			documentStatus = DocumentStatus.documentStatusWithOutPassword(version);
		}
		
		System.out.println("-------------문서내용을 작성해주세요-----------(종료하시려면, q를 눌러주세요)");
		StringBuffer sb = new StringBuffer();
		String input="";
		while(true) {
			input = KeyBoardInput.scanner.nextLine();
			if("q".equals(input))break;
			sb.append(input+"\n");
		}
		
		Document document = new Document(title, Session.getSession(), sb.toString(), documentStatus, label, path);
		bookMap.get(code).put(label.getRegNumber(), document);
		buildPdf(document);
	}
	
	private void buildPdf(Document document) {
		IOUtil.writeDocumentPdf(document);
	}
	
	
	public static void main(String[] args) {
		Session.setNewSession("1111", new Customer());
		DocumentSys ds = new DocumentSys();
		ds.addNewDocs();
		IOUtil.writeDocumentMapToSerial(ds.bookMap);
		
		ds.bookMap = IOUtil.readDocumentMap();
		
		System.out.println(ds.bookMap);
		
	}
	
	public void showDocuments() {
		System.out.println("***********************문서 조회***********************");
		System.out.println("1.총무부, 2.인사부, 3.경리부, 4.영업구, 5.자재부, 6.기획실, 7.전산실, 8.기타");
		String deptInput = KeyBoardInput.scanner.nextLine();
		showDocsList(Integer.parseInt(deptInput));
	}

	private void showDocsList(int ordinal) {
		// TODO Auto-generated method stub
		showDocList(bookMap.get(DeptCode.getDeptCode(ordinal)).values());
		
	}
	
	public void findDocuments() {
		System.out.println("**********************문서 검색**********************");
		System.out.println("1. 저자, 2. 제목");
		
		String findInput = KeyBoardInput.scanner.nextLine();
		Collection<Document> result= null;
		if("1".equals(findInput)) {
			System.out.println("저자명을 입력해주세요");
			String author = KeyBoardInput.scanner.nextLine();
			result = findByAuthor(author);
		}else {
			System.out.println("제목을 입력해주세요");
			String title = KeyBoardInput.scanner.nextLine();
			result = findByTitle(title);
		}
		
		showDocList(result);
		
	}
	
	private void showDocList(Collection<Document> result) {
		for(Document docs : result) {
			docs.showInfo();
		}
		
	}

	private Collection<Document> findByAuthor(String author){
		List<Document> result= new ArrayList<>();
		for(Map<String, Document> books : bookMap.values()) {
			for(Document docs : books.values()) {
				if(docs.getCustomer().getName().contains(author)) {
					result.add(docs);
				}
			}
		}
		return result;
	} 
	
	private Collection<Document> findByTitle(String title){
		List<Document> result= new ArrayList<>();
		for(Map<String, Document> books : bookMap.values()) {
			for(Document docs : books.values()) {
				if(docs.getDocumentTitle().contains(title)) {
					result.add(docs);
				}
			}
		}
		return result;
	} 
	
	public void showDocumentDetail(String regNumber) {
		for(Map<String,Document> books : bookMap.values()) {
			if(books.get(regNumber) != null) {
				books.get(regNumber).showInfo();
			}
		}
	}
	
	private Document findDocumentByRegNumber(String regNumber) {
		for(Map<String,Document> books : bookMap.values()) {
			if(books.get(regNumber) != null) {
				return books.get(regNumber);
			}
		}
		return null;
	}
	private void removeDocumentFromDocMap(Document docs) {
		
	}
	
	public void modifyDocs(Document docs) {
		System.out.println("**************수정할 내용을 입력해주세요************");
		StringBuffer sb = new StringBuffer();
		String input="";
		while(true) {
			input = KeyBoardInput.scanner.nextLine();
			if("q".equals(input))break;
			sb.append(input+"\n");
		}
		rollbackSYs.rollBackDocs(docs);
		Document newDocs = docs.getNewVersionDocs(sb.toString());
		updateBookMap(newDocs);
		IOUtil.writeDocumentPdf(newDocs);
		//Document docfindDocumentByRegNumber(regNumber);
		
	}
	
	public void changeDocVersion(Document docs) {
		System.out.println("**************돌아가실 문서 버전을 선택해주세요******************");
		Collection<Document> modiDocs = this.rollbackSYs.getLastVersionDocs(docs.getLabel().getRegNumber());
		for(Document doc : modiDocs) {
			doc.showVersionAndModifiedDate();
		}
		String getversions = KeyBoardInput.scanner.nextLine();
		Document selectedDocument = rollbackSYs.findVersionDocs(docs.getDocumentStatus().getversionName(),getversions);
		updateBookMap(selectedDocument);
		
		System.out.println("********************************************************");
	}
	
	private void updateBookMap(Document newDocs) {
		bookMap.get(newDocs.getLabel().getDeptCode()).put(newDocs.getLabel().getRegNumber(),newDocs);
	}
	
}
