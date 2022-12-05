package model.dto;

public class ReviewDTO {
	private int id;
	private String title;
	private int performance_id;
	private int member_id;
	private String member_name;
	private String content;

	public ReviewDTO(int id, String title, int performance_id, int member_id, String member_name, String content) {
		super();
		this.id = id;
		this.title = title;
		this.performance_id = performance_id;
		this.member_id = member_id;
		this.member_name = member_name;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}