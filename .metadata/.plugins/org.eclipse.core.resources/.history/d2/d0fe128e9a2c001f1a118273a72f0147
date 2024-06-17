package filenest.domain;

import java.io.Serializable;
import java.text.DateFormat;

import filenest.domain.label.Label;
import filenest.util.DateFormatter;

public class Document implements Serializable{
	

	
	private String documentTitle;
	private Customer customer;
	private String content;
	private DocumentStatus documentStatus;
	private Label label;
	private String path;
	
	
	public Document(String title,Customer customer,String content, 
			DocumentStatus documentStatus,Label lable,String path) {
		this.documentTitle = title;
		this.customer = customer;
		this.content = content;
		this.documentStatus = documentStatus;
		this.label = label;
		this.path = path;
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

	public DocumentStatus getDocumentStatus() {
		return documentStatus;
	}

	public Label getLabel() {
		return label;
	}
	
	public void showInfo() {
		System.out.println("*****"+this.documentTitle+"*****");
		customer.toString();
		System.out.println("분류기호:"+label.getDocumentCode());
		System.out.println("저자명:"+this.customer.getName());
		System.out.println("공개 문서 여부 :"+(this.getDocumentStatus().isPrivate() ? "비공개":"공개"));
		System.out.println("문서 버전 : "+this.getDocumentStatus().getversionName());
		System.out.println("최초 등록일:"+DateFormatter.fomatter.format(this.getDocumentStatus().getRegDate()));
		System.out.println("마지막 수정일:"+DateFormatter.fomatter.format(this.getDocumentStatus().getLastModifiedDate()));
		System.out.println("--------------문서 내용--------------");
		System.out.println(this.content);
		System.out.println("----------------------------------");
		System.out.println("**********************************");
		
	}
	

	@Override
	public String toString() {
		return "Document [documentTitle=" + documentTitle + ", customer=" + customer + ", content=" + content
				+ ", documentStatus=" + documentStatus + ", label=" + label + ", path=" + path + "]";
	}


	public String path() {
		
		return this.path;
	}
	
	
	
	
}
