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
	 private List<MyPreference> myPreferences;
	 
	 public Member() {
		super();
	}
	 
	public Member(String id, String password, String gender, String birth, String email,
			List<MyPerformance> myPerformances, List<MyPreference> myPreferences) {
		super();
		this.id = id;
		this.password = password;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.myPerformances = myPerformances;
		this.myPreferences = myPreferences;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<MyPerformance> getMyPerformances() {
		return myPerformances;
	}

	public void setMyPerformances(List<MyPerformance> myPerformances) {
		this.myPerformances = myPerformances;
	}

	public List<MyPreference> getMyPreferences() {
		return myPreferences;
	}

	public void setMyPreferences(List<MyPreference> myPreferences) {
		this.myPreferences = myPreferences;
	}
	
}
