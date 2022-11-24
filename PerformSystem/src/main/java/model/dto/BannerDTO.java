package model.dto;

public class BannerDTO {
	String bannerImg;
	int rank;
	
	
	public BannerDTO(String bannerImg, int rank) {
		super();
		this.bannerImg = bannerImg;
		this.rank = rank;
	}
	
	public String getBannerImg() {
		return bannerImg;
	}
	public void setBannerImg(String bannerImg) {
		this.bannerImg = bannerImg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "BannerDTO [bannerImg=" + bannerImg + ", rank=" + rank + "]";
	}
	
	
}
