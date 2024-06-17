package filenest.system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import filenest.domain.Customer;
import filenest.domain.Manager;

public class CustomerSys {
	 private List<Customer> customers;
	    private List<Customer> blackList;
	    //private AdminAlarmSys adminAlarmSys;
	    //private Admin adminUser;
	    private Scanner sc;
	    private Manager manager = new Manager("장상원","0070","id");
	    public CustomerSys() {
	        customers = new ArrayList<>();
	        blackList = new ArrayList<>();
	    }

	    public void manLogin() {
	        System.out.println("=============================");
	        System.out.println("매니저 로그인");
	        System.out.println("=============================");
	        boolean islogin = false;
	        while (!islogin) {
	            System.out.println("아이디를 입력해 주세요:");
	            String loginId = sc.nextLine();
	            System.out.println("비밀번호를 입력해 주세요:");
	            String loginPwd = sc.nextLine();
	            if(loginId.equals(manager.getAdminId()) && loginPwd.equals(manager.getAdminPassword())){
	                System.out.println("로그인 완료");
	                manSys();
	                islogin = true;
	            }else{
	                System.out.println("다시 로그인 해주세요:");
	            }

	        }
	    }

	    public void manSys(){
	        System.out.println("=====================================================");
	        System.out.println("1. 계정관리 2. 문서관리 3. QnA 리스트 4. 답변한 QnA 리스트 ");
	        System.out.println("=====================================================");
	        String choose = sc.nextLine();
	        switch (choose){
	            case "1":
	                System.out.println("======");
	                System.out.println("계정관리");
	                System.out.println("======");
	                int count = 1;
	                for(int i=0; i<customers.size(); i++){
	                    System.out.println(count++ + " ." + customers.get(i).getId());
	                    //페이징
	                }
	                System.out.println("차단할 번호를 선택해주세요 :");
	                int blackNum = sc.nextInt();
	                sc.nextLine();
	                String blackId = customers.get(blackNum-1).getId();
	                blackList.add(new Customer(blackId));

	                System.out.println("차단된 아이디는 :" + blackList.get(0).getId());


	        }
	    }
	    public void cusRegister() {
	        System.out.println("=============================");
	        System.out.println("회원 등록");
	        System.out.println("=============================");

	        sc = new Scanner(System.in);
	        while (true) {
	            System.out.println("회원가입을 하시겠습니까?\nY: 진행 N: 취소");
	            System.out.println(" >> ");
	            String registerInput = sc.nextLine();
	            // 대문자 소문자 상관없음 equalsIgnoreCase, 공백무시
	            if (registerInput.trim().equalsIgnoreCase("y")) {
	                System.out.println("=============================");
	                System.out.println("회원가입이 진행됩니다.");
	                System.out.println("=============================");
	                break;
	            } else if (registerInput.equalsIgnoreCase("n")) {
	                System.out.println("=============================");
	                System.out.println("회원가입이 종료됩니다.");
	                System.out.println("=============================");
	                // if (register) {break;}
	                break;

	            } else {
	                System.out.println("입력값을 확인해주세요.");
	            }

	        }
	        System.out.println("아이디를 입력해 주세요:");
	        String id = "";

	        while (true) {
	            id = sc.nextLine();
	            for (int i = 0; i < customers.size(); i++) {
	                if (customers.get(i).getName().equals(id)) System.out.println("해당 아이디로 이미 가입된 회원이 존재합니다.");
	            }
	            break;
	        }

	        System.out.println("이름을 입력해 주세요:");
	        String name = sc.nextLine();

	        System.out.println("전화번호를 입력해 주세요 (예시: 010-1234-1234) :");
	        String phoneRegex = "^010-[0-9]{4}-[0-9]{4}$";
	        String phoneNumber = "";
	        while (true) {
	            phoneNumber = sc.nextLine();
	            if (phoneNumber.matches(phoneRegex)) {
	                System.out.println("올바른 전화번호 형식입니다.");
	                // 여기서부터 유효한 전화번호 처리를 추가할 수 있음
	                break;
	            } else {
	                System.out.println("올바른 전화번호 형식이 아닙니다. 다시 입력해 주세요.");
	                // 다시 입력을 받거나 다른 처리를 할 수 있음
	            }
	        }


	        System.out.println("비밀번호를 입력해 주세요:");
	        String pwd = sc.nextLine();

	        while (true) {
	            System.out.println("비밀번호 확인 :");
	            String passwordConfirm = sc.nextLine();
	            if (passwordConfirm.equals(pwd)) {
	                System.out.println("비밀번호가 일치합니다.");
	                break;
	            } else {
	                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해 주세요:");
	            }
	        }
	        String email = "";
	        while (true) {
	            System.out.println("이메일을 입력해 주세요:");
	            email = sc.nextLine();
	            for (int i = 0; i < customers.size(); i++) {
	                if (customers.get(i).getEmail().equals(email)) System.out.println("중복된 이메일 입니다. 다시 입력해주세요:");
	            }

	            break;

	        }

	        String dept = "";
	        while (true) {
	            System.out.print("부서명을 입력하세요: ");
	            dept = sc.nextLine();

	            if (dept.equals("총무부") || dept.equals("인사부") || dept.equals("경리부") ||
	                    dept.equals("영업부") || dept.equals("자재부") || dept.equals("기획실") ||
	                    dept.equals("전산실")) {
	                // 올바른 부서명이 입력되면 while 루프를 종료하고 다음으로 넘어감
	                break;
	            } else {
	                // 부서명이 올바르지 않으면 다시 입력 요청
	                System.out.println("부서명을 다시 입력해 주세요.");
	            }
	        }
	        // 현재 날짜 가져오기
	        LocalDate currentDate = LocalDate.now();

	        // 생년월일 입력
	        String birth = "";
	        while (true) {
	            System.out.println("생년월일을 입력해 주세요 (예시: 1997/04/02):");
	            birth = sc.nextLine();

	            // 생년월일 유효성 검사를 위한 정규표현식
	            String birthRegex = "^\\d{4}/\\d{2}/\\d{2}$";

	            if (!birth.matches(birthRegex)) {
	                System.out.println("올바른 생년월일 형식이 아닙니다. 다시 입력해 주세요.");
	                continue;
	            }

	            // 입력된 생년월일을 LocalDate로 변환
	            LocalDate birthDate = LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

	            // 현재 날짜와 비교하여 유효성 검사
	            if (birthDate.isAfter(currentDate)) {
	                System.out.println("생년월일은 현재 날짜보다 앞선 날짜여야 합니다. 다시 입력해 주세요.");
	                continue;
	            }
	            // 유효한 경우 반복문을 빠져나옴
	            break;
	        }

	        customers.add(new Customer(name, id, pwd, email, phoneNumber, dept, birth));

	        System.out.println("회원가입이 완료 되었습니다.");

	    }


	    public void login() {
	        System.out.println("=============================");
	        System.out.println("로그인");
	        System.out.println("=============================");
	        System.out.println("1. 로그인 시작  2. 아이디 찾기  3. 비밀번호 찾기 ");
	        String choose = sc.nextLine();
	        switch (choose) {
	            case "1":
	                System.out.println("1. 회원 로그인, 2. 관리자로 로그인");
	                String number = sc.nextLine();
	                if(number.equals("1")){
	                    boolean islogin = false;
	                    while (!islogin) {
	                        System.out.println("아이디를 입력해 주세요:");
	                        String loginId = sc.nextLine();
	                        boolean isBlacklisted = false;
	                        for (int i = 0; i < blackList.size(); i++) {
	                            if (blackList.get(i).getId().equals(loginId)) {
	                                System.out.println("사용금지 된 ID 입니다.");
	                                System.out.println("사유 : 부적절한 문서 등록");
	                                isBlacklisted = true;
	                                break;
	                            }
	                        }

	                        // 사용금지된 ID일 경우 다시 아이디 입력 단계로 돌아감
	                        if (isBlacklisted) {
	                            continue;
	                        }

	                        System.out.println("비밀번호를 입력해 주세요:");
	                        String loginPwd = sc.nextLine();
	                        for (int i = 0; i < customers.size(); i++) {
	                            if (customers.get(i).getId().equals(loginId) && customers.get(i).getPwd().equals(loginPwd)) {

	                                //|| (customers.get(i).getId().equals("id") && customers.get(i).getPwd().equals("0070"))){
	                                System.out.println("로그인이 완료 되었습니다.");
	                                islogin = true;
	                                break;
	                            } else {
	                                System.out.println("다시 입력해 주세요.");
	                            }
	                        }
	                    }
	                }else if(number.equals("2")){
	                    manLogin();
	                    break;
	                }


	            case "2":
	                boolean findId = false;
	                while (!findId) {
	                    System.out.println("이름을 입력해 주세요 :");
	                    String findName = sc.nextLine();
	                    System.out.println("전화번호를 입력해 주세요 :");
	                    String findNum = sc.nextLine();
	                    for (int i = 0; i < customers.size(); i++) {
	                        if (customers.get(i).getName().equals(findName) && customers.get(i).getPhoneNumber().equals(findNum)) {
	                            System.out.println("회원님의 id는 " + customers.get(i).getId() + " 입니다.");

	                            findId = true;
	                            break;
	                        } else {
	                            System.out.println("등록된 회원ID가 존재하지 않습니다.");
	                        }
	                    }
	                }

	            case "3":
	                boolean findpw = false;
	                String pwd = "";
	                while (!findpw) {
	                    System.out.println("id를 입력해 주세요 :");
	                    String id = sc.nextLine();
	                    System.out.println("이름을 입력해 주세요 :");
	                    String findName = sc.nextLine();
	                    System.out.println("전화번호를 입력해 주세요 :");
	                    String findNum = sc.nextLine();
	                    for (int i = 0; i < customers.size(); i++) {
	                        if (customers.get(i).getName().equals(findName) && customers.get(i).getPhoneNumber().equals(findNum) && customers.get(i).getId().equals(id)) {
	                            System.out.println("=============================");
	                            System.out.println("비밀번호 재설정");
	                            System.out.println("=============================");
	                            System.out.println("비밀번호를 입력해 주세요:");
	                            pwd = sc.nextLine();
	                            customers.get(i).changePwd(pwd);
	                            System.out.println("비밀번호 재설정이 완료 되었습니다.");
	                            findpw = true;
	                            break;
	                        } else {
	                            System.out.println("등록된 정보가 존재하지 않습니다.");
	                        }
	                    }
	                }

	        }


	    }
}
