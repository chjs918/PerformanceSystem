package model;

import java.util.List;

/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */
public class Member {
	 private String id;
	 private String password;
	 private String gender;
	 private String birth;
	 private String email;
	 private List<MyPerformance> myPerformances;
	 
	 public Member() {
		super();
	}
	 
	public Member(String id, String password, String gender, String birth, String email,
			List<MyPerformance> myPerformances) {
		super();
		this.id = id;
		this.password = password;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.myPerformances = myPerformances;
	}
	
	 public Member(String id, String gender, String birth, String email, List<MyPerformance> myPerformances) {
		super();
		this.id = id;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.myPerformances = myPerformances;
	}


	
}
