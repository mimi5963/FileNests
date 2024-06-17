package filenest.system;

import filenest.domain.QnA;
import filenest.observer.CustomerAlarmObserver;

public class CustomerAlarmSys implements CustomerAlarmObserver {
	 @Override
	    public void update(QnA qna) {
	        System.out.println("[고객 알림] 답변이 등록되었습니다. 문의 제목: " + qna.getQnaTitle());
	    }
}
