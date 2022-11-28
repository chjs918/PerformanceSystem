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
	 private String area;
	 private String strength;
	 private String type;
	 private String view;
	 private String stable;
	 private List<MyPerformance> myPerformances;
	 
	 public Member() {
		super();
	}

	public Member(String id, String name, String password, String gender, String birth, String email, String area,
			String strength, String type, String view, String stable) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.area = area;
		this.strength = strength;
		this.type = type;
		this.view = view;
		this.stable = stable;
	}


	public Member(String id, String name, String password, String gender, String birth, String email,
			String area, String strength, String type,
			String view, String stable, List<MyPerformance> myPerformances) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.area = area;
		this.strength = strength;
		this.type = type;
		this.view = view;
		this.stable = stable;
		this.myPerformances = myPerformances;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getStable() {
		return stable;
	}

	public void setStable(String stable) {
		this.stable = stable;
	}

	public List<MyPerformance> getMyPerformances() {
		return myPerformances;
	}

	public void setMyPerformances(List<MyPerformance> myPerformances) {
		this.myPerformances = myPerformances;
	}
	

	
}