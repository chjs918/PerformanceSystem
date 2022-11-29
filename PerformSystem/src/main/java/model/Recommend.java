package model;

public class Recommend {
	private int id;
	private int performance_id;
	private String recommend_img;
	private String recommend_seat;
	private String area;
	private String strength;
	private String type;
	private String view;
	private String stable;
	
	public Recommend(int id, int performance_id, String recommend_img, String recommend_seat, String area, String strength,
			String type, String view, String stable) {
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
}