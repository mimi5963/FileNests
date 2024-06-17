package filenest.domain;

import java.io.Serializable;
import java.util.Date;

public class DocumentStatus implements Serializable{
	@Override
	public String toString() {
		return "DocumentStatus [regDate=" + regDate + ", lastModifiedDate=" + lastModifiedDate + ", versionName="
				+ versionName + ", isPrivate=" + isPrivate + "]";
	}

	private Date regDate;
	private Date lastModifiedDate;
	private String versionName;
	private boolean isPrivate;
	private String password;
	
	public DocumentStatus() {}
	
	private DocumentStatus(Date regDate , Date lastModifiedDate, String verseionName, boolean isPrivate, String password) {
		this.regDate =regDate;
		this.lastModifiedDate = lastModifiedDate;
		this.versionName = verseionName;
		this.versionName = versionName;
		this.isPrivate = isPrivate;
		this.password = password;
	}
	private DocumentStatus(Date regDate, Date lastModiDate, String versionName, boolean isPrivate) {
		this.regDate = regDate;
		this.lastModifiedDate = lastModiDate;
		this.versionName = versionName;
		this.isPrivate=isPrivate;
	}
	public static DocumentStatus modifiedStatus(DocumentStatus docStatus) {
		String[] versions =  docStatus.getversionName().split("-");
		String newVersion = versions[0]+"_"+(Integer.parseInt(versions[1])+1);
		return new DocumentStatus(docStatus.regDate,new Date(),newVersion,docStatus.isPrivate,docStatus.password);
	}
	public static DocumentStatus documentStatusWithPassword(String pass, String versionName) {
		return new DocumentStatus(new Date(),new Date(), versionName,true,pass);
	}
	
	public static DocumentStatus documentStatusWithOutPassword(String versionName) {
		return new DocumentStatus(new Date(),new Date(),versionName,false);
	}
	public String getversionName() {
		return this.versionName;
	}
	public boolean isPrivate() {
		return this.isPrivate;
	}

	public Date getRegDate() {
		
		return this.regDate;
	}

	public Date getLastModifiedDate() {
		
		return this.lastModifiedDate;
	}
}
