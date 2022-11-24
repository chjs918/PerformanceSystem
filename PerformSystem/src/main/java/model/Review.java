package model;

public class Review {
	private int id;
	private int performance_id;
	private int member_id;
	private String title;
	private String content;
	
	public Review(int id, int performance_id, int member_id, String title, String content) {
		super();
		this.id = id;
		this.performance_id = performance_id;
		this.member_id = member_id;
		this.title = title;
		this.content = content;
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

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
