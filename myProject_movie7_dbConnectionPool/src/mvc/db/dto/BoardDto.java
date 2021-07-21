package mvc.db.dto;

public class BoardDto {
	private int artiNum;
	private String artiTitle;
	private String writer;
	private String artiDate;	
	private String openPublic;
	private String image;
	private String content;	
	private String isActive;
	
	public int getArtiNum() {
		return artiNum;
	}
	public BoardDto setArtiNum(int artiNum) {
		this.artiNum = artiNum;
		return this;
	}
	public String getArtiTitle() {
		return artiTitle;
	}
	public BoardDto setArtiTitle(String artiTitle) {
		this.artiTitle = artiTitle;
		return this;
	}
	public String getWriter() {
		return writer;
	}
	public BoardDto setWriter(String writer) {
		this.writer = writer;
		return this;
	}
	public String getArtiDate() {
		return artiDate;
	}
	public BoardDto setArtiDate(String artiDate) {
		this.artiDate = artiDate;
		return this;
	}
	public String getOpenPublic() {
		return openPublic;
	}
	public BoardDto setOpenPublic(String openPublic) {
		this.openPublic = openPublic;
		return this;
	}
	public String getImage() {
		return image;
	}
	public BoardDto setImage(String image) {
		this.image = image;
		return this;
	}
	public String getContent() {
		return content;
	}
	public BoardDto setContent(String content) {
		this.content = content;
		return this;
	}
	public String getIsActive() {
		return isActive;
	}
	public BoardDto setIsActive(String isActive) {
		this.isActive = isActive;
		return this;
	}
}
