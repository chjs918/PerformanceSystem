package model.dto;

public class ListDTO {
	String name, img, category, runtime, agegroup, site_link, cast, PERFORMANCE_ID;

	public ListDTO(String name, String img, String category, String runtime, String agegroup, String site_link,
			String cast, String pERFORMANCE_ID) {
		super();
		this.name = name;
		this.img = img;
		this.category = category;
		this.runtime = runtime;
		this.agegroup = agegroup;
		this.site_link = site_link;
		this.cast = cast;
		PERFORMANCE_ID = pERFORMANCE_ID;
	}

	public String getPERFORMANCE_ID() {
		return PERFORMANCE_ID;
	}

	public void setPERFORMANCE_ID(String pERFORMANCE_ID) {
		PERFORMANCE_ID = pERFORMANCE_ID;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getAgegroup() {
		return agegroup;
	}

	public void setAgegroup(String agegroup) {
		this.agegroup = agegroup;
	}

	public String getSite_link() {
		return site_link;
	}

	public void setSite_link(String site_link) {
		this.site_link = site_link;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

}
