package filenest.domain.label;

public enum DeptCode {
	
	
	
	GeneralAffairs(0,"G",new String[]{"1.사무관리","2.후생관리","3.계약관리","4.회의관리","5.의전관리"}),
	HumanResources(1,"H",new String[] {"1.조직문화","2.노사관리","3.채용","4.성과평가","5.인사기획"}),
	Accounting(2,"A",new String[]{"1.예산관리","2.자금관리","3.일반회계","4.마감/결산","5.구매/자산관리"} ),
	SalesTeam(3,"S",new String[]{"1.영업기획","2.마케팅","3.고객관리"}),
	Materials(4,"M",new String[]{"1.재고관리","2.품질관리","3.자재조달","4.운송관리"}),
	Planning(5,"P",new String[]{"1.사무관리","2.후생관리","3.계약관리","4.회의관리","5.의전관리"}),
	IT(6,"I",new String[]{"1.인프라관리","2.기술지원","3.보안관리","4.애플리케이션개발"}),
	Etc(7,"E",new String[]{"1.교육","2.취미"});
	
	private int deptCode;
	private String initial;
	private String[] docs;

	
	
	private DeptCode(int deptCode, String initial, String[] docs) {
		this.deptCode = deptCode;
		this.initial = initial;
		this.docs = docs;
	}
	
	public int getDeptCode() {
		return this.deptCode;
	}
	public String getInitial() {
		return this.initial;
	}
	
	public String getClassficationCode() {
		return initial+"-"+deptCode;
	}
	
	public static DeptCode getDeptCode(int ordinal) {
		for(DeptCode dc : DeptCode.values()) {
			if(dc.getDeptCode() == ordinal-1) {
				return dc;
			}
		}
		return null;
	}
	public void showOperationCodes() {
		for(String codes : this.docs) {
			System.out.print(codes+" ");
		}
	}
	
}
