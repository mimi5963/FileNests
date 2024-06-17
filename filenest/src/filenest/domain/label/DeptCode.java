package filenest.domain.label;

public enum DeptCode {
	
	
	
	GeneralAffairs(0,"G",new String[]{"1.사무관리","2.후생관리","3.계약관리","4.회의관리","5.의전관리"}),
	HumanResources(1,"H",new String[] {"1.사무관리","2.후생관리","3.계약관리","4.회의관리","5.의전관리"}),
	Accounting(2,"A",new String[]{"1.사무관리","2.후생관리","3.계약관리","4.회의관리","5.의전관리"} ),
	SalesTeam(3,"S",new String[]{"1.사무관리","2.후생관리","3.계약관리","4.회의관리","5.의전관리"}),
	Materials(4,"M",new String[]{"1.사무관리","2.후생관리","3.계약관리","4.회의관리","5.의전관리"}),
	Planning(5,"P",new String[]{"1.사무관리","2.후생관리","3.계약관리","4.회의관리","5.의전관리"}),
	IT(6,"I",new String[]{"1.사무관리","2.후생관리","3.계약관리","4.회의관리","5.의전관리"}),
	Etc(7,"E",new String[]{"1.사무관리","2.후생관리","3.계약관리","4.회의관리","5.의전관리"});
	
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
