package model;

public class Performance {
	private int id;
	private String img;
	private String name;
	private String startDate;
	private String endDate;
	private String ageGroup;
	private int runTime;
	private String cast;
	private String venue;
	private int price;
	private String category;
	private String link;
	private int rank;

	public Performance(String name, String startDate, String endDate) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Performance(int id, String img, String name, String startDate, String endDate, String ageGroup, int runTime,
			String cast, String venue, int price, String category, String link, int rank) {
		super();
		this.id = id;
		this.img = img;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.ageGroup = ageGroup;
		this.runTime = runTime;
		this.cast = cast;
		this.venue = venue;
		this.price = price;
		this.category = category;
		this.link = link;
		this.rank = rank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
