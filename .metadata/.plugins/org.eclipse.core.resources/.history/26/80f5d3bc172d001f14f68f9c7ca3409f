package filenest.domain;

import java.io.Serializable;

import java.util.Date;

import filenest.Session;
import filenest.domain.label.Label;
import filenest.util.DateFormatter;

public class Document implements Serializable{
	

	//수정은 등록한 사람만 가능하니까 customer -> session title, content,regDate만 가져오면됨
	private String documentTitle;
	private Customer customer;
	private String content;
	private DocumentInfo documentInfo;
	private Label label;


	
	
	public Document(String title, Customer customer, String content,
					DocumentInfo documentInfo, Label label) {
		this.documentTitle = title;
		this.customer = customer;
		this.content = content;
		this.documentInfo = documentInfo;
		this.label = label;
		documentInfo.setVersionNum(label.getRegNumber());
		documentInfo.setLabel(label);
		documentInfo.setTitle(title);
	}

	public Document(DocumentInfo documentInfo, String newContent) {
		this.documentTitle = documentInfo.getTitle();
		this.customer = Session.getSession();
		this.content = newContent;
		this.documentInfo = documentInfo;
		this.label = documentInfo.getLabel();
	}


	public String getDocumentCode() {
		return label.getDocumentCode();
	}
	
	public String getDocumentTitle() {
		return documentTitle;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public String getContent() {
		return content;
	}

	public DocumentInfo getDocumentStatus() {
		return documentInfo;
	}

	public Label getLabel() {
		return label;
	}
	
	public void showInfo() {
//		System.out.println("*****"+this.documentTitle+"*****");
//		customer.toString();
//		System.out.println("분류기호:"+label.getDocumentCode());
//		System.out.println("저자명:"+this.customer.getName());
//		System.out.println("공개 문서 여부 :"+(this.getDocumentStatus().isPrivate() ? "비공개":"공개"));
//		System.out.println("문서 버전 : "+this.getDocumentStatus().getVersionName());
//		System.out.println("최초 등록일:"+DateFormatter.fomatter.format(this.regDate));
//		System.out.println("마지막 수정일:"+DateFormatter.fomatter.format(this.getDocumentStatus().getLastModifiedDate()));
//		System.out.println("--------------문서 내용--------------");
//		System.out.println(this.content);
//		System.out.println("----------------------------------");
//		System.out.println("**********************************");
		
	}
	

	@Override
	public String toString() {
		return "Document [documentTitle=" + documentTitle + ", customer=" + customer + ", content=" + content
				+ ", documentStatus=" + documentInfo + ", label=" + label + ", path=" + "]";
	}





	public Document getNewVersionDocs(String content) {
		DocumentInfo newStatus = this.documentInfo.modifiedStatus(this.documentInfo);
		return new Document(this.documentTitle, customer, content, newStatus, this.label);
	}
	
	public void showVersionAndModifiedDate() {
		System.out.println("제목 : "+this.documentTitle);
		System.out.println("최종수정일 : "+DateFormatter.fomatter.format(this.documentInfo.getLastModifiedDate()));
		System.out.println("버전 정보 : "+this.documentInfo.getShortVersionName());
	}

	public String getUploadFormat(){
		return  "*".repeat(25)
				+"문서명 : "+this.documentTitle+"\t등록번호:"+this.label.getRegNumber()+"\t저자:"+this.customer.getName()+"\n"
				+"-".repeat(10)+"문서정보"+"-".repeat(10)+"\n"
				+"분류기호 :"+this.label.getDocumentCode()+"\t문서버전:"+ documentInfo.getShortVersionName()+"\t공개여부:"+(documentInfo.isPrivate() ? "비공개":"공개")+"\n"
				+"등록일자 :"+DateFormatter.fomatter.format(documentInfo.getRegDate())+"\t 최종 수정일:"+DateFormatter.fomatter.format(this.documentInfo.getLastModifiedDate())+"\n"
				+"-----------------------------------------------------------------------------------------------\n"
				+"내용:\n"+this.content;
	}
	
	
}
