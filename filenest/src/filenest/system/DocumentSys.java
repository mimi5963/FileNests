package filenest.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import filenest.Session;
import filenest.domain.Customer;
import filenest.domain.Document;
import filenest.domain.DocumentInfo;
import filenest.domain.label.DeptCode;
import filenest.domain.label.Label;
import filenest.util.FileDown;
import filenest.util.FileIoUtil;
import filenest.util.KeyBoardInput;

public class DocumentSys {
//	//private Map<String,Document> document;
//
//	private RollbackSYs rollbackSYs;
//
//	private EnumMap<DeptCode,Map<String, DocumentInfo>> bookInfoMap;
//	
//	public DocumentSys() {
//
//		bookInfoMap = new EnumMap<DeptCode, Map<String, DocumentInfo>>(DeptCode.class);
//		for(DeptCode code: DeptCode.values()) {
//			bookInfoMap.put(code, new HashMap<>());
//		}
//		
//		this.rollbackSYs = new RollbackSYs();
//	}
//	
//	public void addNewDocs() {
//		Customer cus = Session.getSession();
//		System.out.println("********신규 문서 등록**********");
//		System.out.println("문서명을 입력해주세요");
//		String title = KeyBoardInput.scanner.nextLine();
//		//String version = title+"_v1";
//		//문서 분류 지정
//		System.out.println("문서 분류를 지정해주세요");
//		System.out.println("1.총무부, 2.인사부, 3.경리부, 4.영업구, 5.자재부, 6.기획실, 7.전산실, 8.기타");
//		int deptCode = Integer.parseInt(KeyBoardInput.scanner.nextLine());
//		DeptCode code = DeptCode.getDeptCode(deptCode);
//		System.out.println("문서 세부 분류를 지정해주세요");
//		code.showOperationCodes();
//		int opCode = Integer.parseInt(KeyBoardInput.scanner.nextLine());
//		Label label = new Label(opCode, code); 
//		
//		//문서 상태 지정 
//		System.out.println("문서 공개 여부를 입력해주세요 1.공개, 2.비공개");
//		String publicinput = KeyBoardInput.scanner.nextLine();
//		DocumentInfo documentInfo = null;
//		if(publicinput.equals("2")) {
//			System.out.print("문서 비밀번호를 입력해주세요:");
//			String pass = KeyBoardInput.scanner.nextLine();
//			documentInfo = DocumentInfo.documentStatusWithPassword(pass, 1,cus );
//		}else {
//			documentInfo = DocumentInfo.documentStatusWithOutPassword(1, cus);
//		}
//		
//		System.out.println("-------------문서내용을 작성해주세요-----------(종료하시려면, q를 눌러주세요)");
//		StringBuffer sb = new StringBuffer();
//		String input="";
//		while(true) {
//			input = KeyBoardInput.scanner.nextLine();
//			if("q".equals(input))break;
//			sb.append(input+"\n");
//		}
//		
//		Document document = new Document(title, Session.getSession(), sb.toString(), documentInfo, label);
//
//		//등록번호랑 버전이름으로 저장
//		bookInfoMap.get(code).put(label.getRegNumber(), documentInfo);
//
//		writeDocument(document);
//	}
//
//
//
//
//	private void writeDocument(Document document){
//		FileIoUtil.writeDocument(document);
//	}
//	
//	public static void main(String[] args) {
//		Session.setNewSession("1111", new Customer());
//		DocumentSys ds = new DocumentSys();
//		ds.addNewDocs();
//		//IOUtil.writeDocumentMapToSerial(ds.bookMap);
//		
//		//ds.bookMap = IOUtil.readDocumentMap();
//		
//		//조회
//		ds.showDocuments();
//
//		//문서 검색
//		ds.findDocs();
//
//		
//	}
//
//	private void findDocs() {
//		System.out.println("-".repeat(5)+"문서검색"+"-".repeat(5));
//		String input ="";
//		while (true) {
//			System.out.println("1.저자명, 2. 문서명, 3. 종료");
//			input = KeyBoardInput.scanner.nextLine();
//			switch (input){
//				case "1":
//					findByAuthor();
//					break;
//				case "2":
//					findByTitle();
//					break;
//				case "3":return;
//				default:
//					System.out.println("잘못입력하셨습니다.");
//					break;
//			}
//		}
//
//	}
//
//	public void showDocuments() {
//		System.out.println("***********************문서 조회***********************");
//		String deptInput = "";
//		while (true){
//			System.out.println("조회하실 문서의 부서를 입력해주세요");
//			System.out.println("1.총무부, 2.인사부, 3.경리부, 4.영업구, 5.자재부, 6.기획실, 7.전산실, 8.기타,9.종료");
//			deptInput = KeyBoardInput.scanner.nextLine();
//			if(deptInput.equals("9"))break;
//			System.out.println("-------------------조회 결과---------------------");
//			showDocsList(Integer.parseInt(deptInput));
//			System.out.println("------------------------------------------------");
//			selectDocs();
//		}
//
//
//
//	}
//
//	private void selectDocs() {
//		String input = "";
//		while (true){
//			System.out.println("열람하실 문서의 등록번호를 입력해주세요 (돌아가시려면, q를 입력해주세요)");
//			input = KeyBoardInput.scanner.nextLine();
//			if("q".equals(input)) break;
//			DocumentInfo findDocsInfo = findDocumentInfoByRegNumber(input);
//			if(findDocsInfo == null) System.out.println("해당 등록번호에 문서가 없습니다. 다시 입력해주세요");
//			else readDocument(findDocsInfo);
//
//		}
//	}
//
//	private void readDocument(DocumentInfo findDocsInfo) {
//		FileIoUtil.readDocument(findDocsInfo);
//		String input="";
//		while (true){
//			System.out.println("1.수정하기 2.버전 변경하기,3.문서 삭제하기 4.돌아가기");
//			input = KeyBoardInput.scanner.nextLine();
//			if("3".equals(input))break;
//			else if("1".equals(input)){
//				modifyDocs(findDocsInfo);
//			}else if("2".equals(input)){
//				changeDocVersion(findDocsInfo);
//			}else if("3".equals(input)) {
//				readDocument(findDocsInfo);
//			}
//			else{
//				System.out.println("메뉴에 있는 목록만 선택 가능합니다. 다시 입력해주세요");
//			}
//		}
//	}
//
//	private DocumentInfo findDocumentInfoByRegNumber(String regNumber) {
//		for(Map<String,DocumentInfo> books : bookInfoMap.values()) {
//			if(books.get(regNumber) != null) {
//				return books.get(regNumber);
//			}
//		}
//		return null;
//	}
//
//	private void showDocsList(int ordinal) {
//		// TODO Auto-generated method stub
//		showDocList(this.bookInfoMap.get(DeptCode.getDeptCode(ordinal)).values());
//		
//	}
//
//	
//	private void showDocList(Collection<DocumentInfo> result) {
//		for(DocumentInfo docs : result) {
//			docs.showDocumentInfo();
//			System.out.println();
//		}
//		
//	}
//
//	private Collection<DocumentInfo> findByAuthor(){
//		List<DocumentInfo> result= new ArrayList<>();
//		System.out.print("저자명을 입력해주세요:");
//		String input = KeyBoardInput.scanner.nextLine();
//		for(Map<String,DocumentInfo> books : this.bookInfoMap.values()){
//			for(DocumentInfo documentInfo : books.values()){
//				if(documentInfo.getAuthorName().contains(input)){
//					result.add(documentInfo);
//				}
//			}
//		}
//		showDocList(result);
//		selectDocs();
//		return result;
//	} 
//	
//	private Collection<DocumentInfo> findByTitle(){
//		List<DocumentInfo> result= new ArrayList<>();
//		System.out.print("문서명을 입력해주세요:");
//		String input = KeyBoardInput.scanner.nextLine();
//		for(Map<String,DocumentInfo> books : this.bookInfoMap.values()){
//			for(DocumentInfo documentInfo : books.values()){
//				if(documentInfo.getTitle().contains(input)){
//					result.add(documentInfo);
//				}
//			}
//		}
//		showDocList(result);
//		selectDocs();
//		return result;
//	} 
//	
//
//
//
//	public void modifyDocs(DocumentInfo documentInfo){
//		if(documentInfo.getAuthorId().equals(Session.getSession().getId())){
//			System.out.println("수정하실 내용을 입력해주세요(q를 입력하시면, 수정을 종료합니다)");
//			StringBuffer sb = new StringBuffer();
//			String input="";
//			while(true) {
//				input = KeyBoardInput.scanner.nextLine();
//				if("q".equals(input))break;
//				sb.append(input+"\n");
//			}
//			//롤백
//			rollbackSYs.addRollBackInfo(documentInfo.getLabel().getRegNumber(),documentInfo);
//			DocumentInfo newDocsInfo = documentInfo.changeDocsVersion();
//			Document newDocs = new Document(newDocsInfo,sb.toString());
//			FileIoUtil.writeDocument(newDocs);
//			updateDocInfoMap(newDocsInfo);
//		}else{
//			System.out.println("문서의 저자가 아니므로, 수정하실 수 없습니다.");
//		}
//	}
//
//	private void updateDocInfoMap(DocumentInfo newDocs) {
//		this.bookInfoMap.get(newDocs.getLabel().getDeptCode()).put(newDocs.getLabel().getRegNumber(),newDocs);
//	}
//
//	
//
//
//	public void changeDocVersion(DocumentInfo docs) {
//
//		Collection<DocumentInfo> modiDocs = this.rollbackSYs.getLastVersionDocs(docs.getLabel().getRegNumber());
//		System.out.println("**************+"+docs.getTitle()+"버전정보******************");
//		for (DocumentInfo modiDoc : modiDocs) {
//			modiDoc.showVersionInfo();
//			System.out.println();
//		}
//		System.out.println("********************************************************");
//		String input ="";
//		while (true){
//			System.out.println("돌아가실 문서의 버전명을 입력해주세요 (종료하시려면 q를 눌러주세요)");
//			input = KeyBoardInput.scanner.nextLine();
//			if("q".equals(input)) break;
//			for (DocumentInfo modiDoc : modiDocs) {
//				if(modiDoc.getVersionName().equals(input) || modiDoc.getShortVersionName().equals(input)){
//					docs.rollBackVersion(input);
//					return;
//				}
//			}
//			System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
//		}
//	}
//
//	public void deleteDocs(DocumentInfo removeDocs){
//		//실제 파일 지워야하고, Map에서 관리되는것도 지워야함
//		//버전관리 맵에서 지워주고!
//		for(Map<String,DocumentInfo> books : bookInfoMap.values()) {
//			if(books.get(removeDocs.getLabel().getRegNumber()) != null) {
//				books.remove(removeDocs.getLabel().getRegNumber());
//			}
//		}
//		//최신의 다음 버전이 있는 경우
//		Collection<DocumentInfo> lastVersionDocs = rollbackSYs.getLastVersionDocs(removeDocs.getLabel().getRegNumber());
//
//		if(!lastVersionDocs.isEmpty()){
//			DocumentInfo documentInfo = rollbackSYs.removeVersion(removeDocs);
//			if(documentInfo!=null){
//				updateDocInfoMap(documentInfo);
//			}
//		}
//
//		//물리적 파일 삭제
//		FileIoUtil.removeFile(removeDocs);
//
//	}
	//private Map<String,Document> document;
    private RollbackSYs rollbackSys;
    private EnumMap<DeptCode, Map<String, DocumentInfo>> bookInfoMap;

    public DocumentSys() {
        bookInfoMap = new EnumMap<>(DeptCode.class);
        for (DeptCode code : DeptCode.values()) {
            bookInfoMap.put(code, new HashMap<>());
        }
        this.rollbackSys = new RollbackSYs();
    }

    public void addNewDocs() {
        Customer cus = Session.getSession();
        System.out.println("=================================");
        System.out.println("          신규 문서 등록         ");
        System.out.println("=================================");
        System.out.print("문서명을 입력해주세요: ");
        String title = KeyBoardInput.scanner.nextLine();

        // 문서 분류 지정
        System.out.println("문서 분류를 지정해주세요");
        System.out.println("1.총무부, 2.인사부, 3.경리부, 4.영업부, 5.자재부, 6.기획실, 7.전산실, 8.기타");
        int deptCode = Integer.parseInt(KeyBoardInput.scanner.nextLine());
        DeptCode code = DeptCode.getDeptCode(deptCode);
        System.out.println("문서 세부 분류를 지정해주세요");
        code.showOperationCodes();
        int opCode = Integer.parseInt(KeyBoardInput.scanner.nextLine());
        Label label = new Label(opCode, code);

        // 문서 상태 지정
        System.out.println("문서 공개 여부를 입력해주세요 1.공개, 2.비공개");
        String publicInput = KeyBoardInput.scanner.nextLine();
        DocumentInfo documentInfo;
        if (publicInput.equals("2")) {
            System.out.print("문서 비밀번호를 입력해주세요: ");
            String pass = KeyBoardInput.scanner.nextLine();
            documentInfo = DocumentInfo.documentStatusWithPassword(pass, 1, cus);
        } else {
            documentInfo = DocumentInfo.documentStatusWithOutPassword(1, cus);
        }

        // 문서 내용 작성
        System.out.println("-------------문서 내용을 작성해주세요----------- (종료하시려면, q를 눌러주세요)");
        StringBuilder sb = new StringBuilder();
        String input;
        while (true) {
            input = KeyBoardInput.scanner.nextLine();
            if ("q".equals(input)) break;
            sb.append(input).append("\n");
        }

        Document document = new Document(title, Session.getSession(), sb.toString(), documentInfo, label);
        // 등록번호랑 버전이름으로 저장
        bookInfoMap.get(code).put(label.getRegNumber(), documentInfo);

        writeDocument(document);
        System.out.println("문서가 등록되었습니다.");
    }

    private void writeDocument(Document document) {
        FileIoUtil.writeDocument(document);
    }

    public static void main(String[] args) {
    	//System.out.println("hi");
        Session.setNewSession("1111", new Customer("장원","id","123","mimi","010-6269-0631","총무부","1997/04/02"));
        DocumentSys ds = new DocumentSys();
        ds.addNewDocs();
        
       

        // 문서 조회
        ds.showDocuments();

        // 문서 검색
        //ds.findDocs();
    }

    private void findDocs() {
        System.out.println("=================================");
        System.out.println("          문서 검색             ");
        System.out.println("=================================");
        String input;
        while (true) {
            System.out.println("1. 저자명, 2. 문서명, 3. 종료");
            input = KeyBoardInput.scanner.nextLine();
            switch (input) {
                case "1":
                    findByAuthor();
                    break;
                case "2":
                    findByTitle();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    break;
            }
        }
    }

    public void showDocuments() {
        System.out.println("=================================");
        System.out.println("          문서 조회             ");
        System.out.println("=================================");
        String deptInput;
        while (true) {
            System.out.println("조회하실 문서의 부서를 입력해주세요");
            System.out.println("1.총무부, 2.인사부, 3.경리부, 4.영업부, 5.자재부, 6.기획실, 7.전산실, 8.기타, 9.종료");
            deptInput = KeyBoardInput.scanner.nextLine();
            if (deptInput.equals("9")) break;
            System.out.println("-------------------조회 결과---------------------");
            showDocsList(Integer.parseInt(deptInput));
            System.out.println("------------------------------------------------");
            selectDocs();
        }
    }

    private void selectDocs() {
        String input;
        while (true) {
            System.out.println("열람하실 문서의 등록번호를 입력해주세요 (돌아가시려면, q를 입력해주세요)");
            input = KeyBoardInput.scanner.nextLine();
            if ("q".equals(input)) break;
            DocumentInfo findDocsInfo = findDocumentInfoByRegNumber(input);
            if (findDocsInfo == null) {
                System.out.println("해당 등록번호에 문서가 없습니다. 다시 입력해주세요");
            } else {
                readDocument(findDocsInfo);
            }
        }
    }

    private void readDocument(DocumentInfo findDocsInfo) {
        FileIoUtil.readDocument(findDocsInfo);
        String input;
        while (true) {
            System.out.println("1. 수정하기, 2. 버전 변경하기, 3. 문서 삭제하기,4. 문서 다운로드 받기  5. 돌아가기");
            input = KeyBoardInput.scanner.nextLine();
            if ("5".equals(input)) break;
            switch (input) {
                case "1":
                    modifyDocs(findDocsInfo);
                    break;
                case "2":
                    changeDocVersion(findDocsInfo);
                    break;
                case "3":
                    deleteDocs(findDocsInfo);
                    break;
                case "4":
                	downLoadDocs(findDocsInfo);
                	break;
                default:
                    System.out.println("메뉴에 있는 목록만 선택 가능합니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    private void downLoadDocs(DocumentInfo findDocsInfo) {
		FileDown.downPdf(findDocsInfo);
		
	}

	private DocumentInfo findDocumentInfoByRegNumber(String regNumber) {
        for (Map<String, DocumentInfo> books : bookInfoMap.values()) {
            if (books.get(regNumber) != null) {
                return books.get(regNumber);
            }
        }
        return null;
    }

    private void showDocsList(int ordinal) {
        showDocList(this.bookInfoMap.get(DeptCode.getDeptCode(ordinal)).values());
    }

    private void showDocList(Collection<DocumentInfo> result) {
        for (DocumentInfo docs : result) {
            docs.showDocumentInfo();
            System.out.println();
        }
    }

    private Collection<DocumentInfo> findByAuthor() {
        List<DocumentInfo> result = new ArrayList<>();
        System.out.print("저자명을 입력해주세요: ");
        String input = KeyBoardInput.scanner.nextLine();
        for (Map<String, DocumentInfo> books : this.bookInfoMap.values()) {
            for (DocumentInfo documentInfo : books.values()) {
                if (documentInfo.getAuthorName().contains(input)) {
                    result.add(documentInfo);
                }
            }
        }
        showDocList(result);
        selectDocs();
        return result;
    }

    private Collection<DocumentInfo> findByTitle() {
        List<DocumentInfo> result = new ArrayList<>();
        System.out.print("문서명을 입력해주세요: ");
        String input = KeyBoardInput.scanner.nextLine();
        for (Map<String, DocumentInfo> books : this.bookInfoMap.values()) {
            for (DocumentInfo documentInfo : books.values()) {
                if (documentInfo.getTitle().contains(input)) {
                    result.add(documentInfo);
                }
            }
        }
        showDocList(result);
        selectDocs();
        return result;
    }

    public void modifyDocs(DocumentInfo documentInfo) {
        if (documentInfo.getAuthorId().equals(Session.getSession().getId())) {
            System.out.println("수정하실 내용을 입력해주세요 (q를 입력하시면, 수정을 종료합니다)");
            StringBuilder sb = new StringBuilder();
            String input;
            while (true) {
                input = KeyBoardInput.scanner.nextLine();
                if ("q".equals(input)) break;
                sb.append(input).append("\n");
            }
            // 롤백
            rollbackSys.addRollBackInfo(documentInfo.getLabel().getRegNumber(), documentInfo);
            DocumentInfo newDocsInfo = documentInfo.changeDocsVersion();
            Document newDocs = new Document(newDocsInfo, sb.toString());
            FileIoUtil.writeDocument(newDocs);
            updateDocInfoMap(newDocsInfo);
            System.out.println("문서가 수정되었습니다.");
        } else {
            System.out.println("문서의 저자가 아니므로, 수정할 수 없습니다.");
        }
    }

    private void updateDocInfoMap(DocumentInfo newDocs) {
        this.bookInfoMap.get(newDocs.getLabel().getDeptCode()).put(newDocs.getLabel().getRegNumber(), newDocs);
    }

    public void changeDocVersion(DocumentInfo docs) {
        Collection<DocumentInfo> modiDocs = this.rollbackSys.getLastVersionDocs(docs.getLabel().getRegNumber());
        System.out.println("************** " + docs.getTitle() + " 버전 정보 **************");
        for (DocumentInfo modiDoc : modiDocs) {
            modiDoc.showVersionInfo();
            System.out.println();
        }
        System.out.println("********************************************************");
        String input;
        while (true) {
            System.out.println("돌아가실 문서의 버전명을 입력해주세요 (종료하시려면 q를 눌러주세요)");
            input = KeyBoardInput.scanner.nextLine();
            if ("q".equals(input)) break;
            for (DocumentInfo modiDoc : modiDocs) {
                if (modiDoc.getVersionName().equals(input) || modiDoc.getShortVersionName().equals(input)) {
                    docs.rollBackVersion(input);
                    return;
                }
            }
            System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
        }
    }

    public void deleteDocs(DocumentInfo removeDocs) {
        for (Map<String, DocumentInfo> books : bookInfoMap.values()) {
            if (books.get(removeDocs.getLabel().getRegNumber()) != null) {
                books.remove(removeDocs.getLabel().getRegNumber());
            }
        }
        Collection<DocumentInfo> lastVersionDocs = rollbackSys.getLastVersionDocs(removeDocs.getLabel().getRegNumber());
        if (!lastVersionDocs.isEmpty()) {
            DocumentInfo documentInfo = rollbackSys.removeVersion(removeDocs);
            if (documentInfo != null) {
                updateDocInfoMap(documentInfo);
            }
        }
        FileIoUtil.removeFile(removeDocs);
        System.out.println("문서가 삭제되었습니다.");
    }


	
}
