package model;

import java.util.List;

/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */
public class Member {
	 private int member_id;
	 private String id;
	 private String password;
	 private String name;
	 private String gender;
	 private String birth;
	 private String email;
	 private char area;
	 private char strength;
	 private char types;
	 private char views;
	 private char stable;
	 
	 public Member() {
		super();
	}

	public Member(String id, String name, String password, String gender, String birth, String email,
			List<MyPerformance> myPerformances, List<MyPreference> myPreferences, char area, char strength, char types,
			char views, char stable) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.area = area;
		this.strength = strength;
		this.types = types;
		this.views = views;
		this.stable = stable;
	}
	
	

	public Member(String id, String password, String name, String gender, String birth, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public char getArea() {
		return area;
	}

	public void setArea(char area) {
		this.area = area;
	}

	public char getStrength() {
		return strength;
	}

	public void setStrength(char strength) {
		this.strength = strength;
	}

	public char getTypes() {
		return types;
	}

	public void setTypes(char types) {
		this.types = types;
	}

	public char getViews() {
		return views;
	}

	public void setViews(char views) {
		this.views = views;
	}

	public char getStable() {
		return stable;
	}

	public void setStable(char stable) {
		this.stable = stable;
	}
	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}
}