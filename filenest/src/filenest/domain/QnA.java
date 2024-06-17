package filenest.domain;

public class QnA {

	  private Customer customer;
	    private String qnaTitle;
	    private String qnaContent;
	    private boolean qnaStatus;
	    private String qnaAnswer;
	    private String qnaRegDate;

	    public QnA() {
	    }

	    public QnA(Customer customer, String qnaTitle, String qnaContent, boolean qnaStatus, String qnaAnswer, String qnaRegDate) {
	        this.customer = customer;
	        this.qnaTitle = qnaTitle;
	        this.qnaContent = qnaContent;
	        this.qnaStatus = qnaStatus;
	        this.qnaAnswer = qnaAnswer;
	        this.qnaRegDate = qnaRegDate;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }

	    public String getQnaTitle() {
	        return qnaTitle;
	    }

	    public void setQnaTitle(String qnaTitle) {
	        this.qnaTitle = qnaTitle;
	    }

	    public String getQnaContent() {
	        return qnaContent;
	    }

	    public void setQnaContent(String qnaContent) {
	        this.qnaContent = qnaContent;
	    }

	    public boolean isQnaStatus() {
	        return qnaStatus;
	    }

	    public void setQnaStatus(boolean qnaStatus) {
	        this.qnaStatus = qnaStatus;
	    }

	    public String getQnaAnswer() {
	        return qnaAnswer;
	    }

	    public void setQnaAnswer(String qnaAnswer) {
	        this.qnaAnswer = qnaAnswer;
	    }

	    public String getQnaRegDate() {
	        return qnaRegDate;
	    }

	    public void setQnaRegDate(String qnaRegDate) {
	        this.qnaRegDate = qnaRegDate;
	    }

	    @Override
	    public String toString() {
	        return
	                "작성자 : " + customer.getName() + "\n" +
	                        ", 제목 : " + qnaTitle + "\n" +
	                        ", 내용 : " + qnaContent + "\n" +
	                        ", 답변 내용 : " + qnaAnswer  + "\n" +
	                        ", 등록 일자 : " + qnaRegDate + "\n" +
	                        "==============================="
	                ;
	    }
}
