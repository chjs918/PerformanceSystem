package model;

public class Recommend {
	private int id;
	private int performance_id;
	private String recommend_img;
	private String recommend_seat;
	private char area;
	private char strength;
	private char type;
	private char view;
	private char stable;
	
	public Recommend(int id, int performance_id, String recommend_img, String recommend_seat, char area, char strength,
			char type, char view, char stable) {
		super();
		this.id = id;
		this.performance_id = performance_id;
		this.recommend_img = recommend_img;
		this.recommend_seat = recommend_seat;
		this.area = area;
		this.strength = strength;
		this.type = type;
		this.view = view;
		this.stable = stable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPerformance_id() {
		return performance_id;
	}

	public void setPerformance_id(int performance_id) {
		this.performance_id = performance_id;
	}

	public String getRecommend_img() {
		return recommend_img;
	}

	public void setRecommend_img(String recommend_img) {
		this.recommend_img = recommend_img;
	}

	public String getRecommend_seat() {
		return recommend_seat;
	}

	public void setRecommend_seat(String recommend_seat) {
		this.recommend_seat = recommend_seat;
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