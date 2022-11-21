package model;

import java.util.List;

/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */
public class Member {
	 private String id;
	 private String name;
	 private String password;
	 private String gender;
	 private String birth;
	 private String email;
	 private List<MyPerformance> myPerformances;
	 private List<MyPreference> myPreferences;
	 private char area;
	 private char strength;
	 private char type;
	 private char view;
	 private char stable;
	 
	 public Member() {
		super();
	}

	public Member(String id, String name, String password, String gender, String birth, String email,
			List<MyPerformance> myPerformances, List<MyPreference> myPreferences, char area, char strength, char type,
			char view, char stable) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.myPerformances = myPerformances;
		this.myPreferences = myPreferences;
		this.area = area;
		this.strength = strength;
		this.type = type;
		this.view = view;
		this.stable = stable;
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

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public char getView() {
		return view;
	}

	public void setView(char view) {
		this.view = view;
	}

	public char getStable() {
		return stable;
	}

	public void setStable(char stable) {
		this.stable = stable;
	}
}
