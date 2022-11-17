package model;

/**
 * 사용자 관리를 위해 필요한 도메인 클래스. USERINFO 테이블과 대응됨
 */
class Member {
	 String id;
	 String password;
	 String gender;
	 String birth;
	 String email;
	 List<MyPerformance> myPerformances;
	 addMyPerformance(){
	 MyPerformance<> mp = MyPerformance<>(name);
	 mp.add(mp)
	 return mp;
	}
	deleteMyPerformance(){
	 MyPerformance<> mp = MyPerformance<>(name);
	 mp.delete(mp)
	 return mp;
	}
	MyPerformance<List> getMyPerformance() {
	 MyPerformance<List> mp = new MyPerformance<List>(name, date);
	 return mp;
	}
	}
	class Category {
	 String name;
	}
	class MyPerformance{
	 String name;
	 String date;
	}
	class Recommand{
	 String[] layers;
	String[] images;
	
	
}