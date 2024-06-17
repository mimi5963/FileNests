package filenest.domain.label;

import java.io.Serializable;

public class Label implements Serializable{
	
	private int operationCode;
	private DeptCode deptCode;
	private String regNumber;
	private static int regCount=0;
	

	public Label(int operationCode, DeptCode deptCode) {
		this.operationCode = operationCode;
		this.deptCode = deptCode;
		this.regNumber="KMS"+"0".repeat(4-(regCount+"").length())+regCount;
	}
	
	public String getDocumentCode() {
		
		return deptCode.getClassficationCode()+operationCode;
	}

	@Override
	public String toString() {
		return "Label [operationCode=" + operationCode + ", deptCode=" + deptCode.getClassficationCode() + "]";
	}
	
	public String getRegNumber() {
		return this.regNumber;
	}
}
