package mvc.db.vo;

public class BoardVO {
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
	public BoardVO setArtiNum(int artiNum) {
		this.artiNum = artiNum;
		return this;
	}
	public String getArtiTitle() {
		return artiTitle;
	}
	public BoardVO setArtiTitle(String artiTitle) {
		this.artiTitle = artiTitle;
		return this;
	}
	public String getWriter() {
		return writer;
	}
	public BoardVO setWriter(String writer) {
		this.writer = writer;
		return this;
	}
	public String getArtiDate() {
		return artiDate;
	}
	public BoardVO setArtiDate(String artiDate) {
		this.artiDate = artiDate;
		return this;
	}
	public String getOpenPublic() {
		return openPublic;
	}
	public BoardVO setOpenPublic(String openPublic) {
		this.openPublic = openPublic;
		return this;
	}
	public String getImage() {
		return image;
	}
	public BoardVO setImage(String image) {
		this.image = image;
		return this;
	}
	public String getContent() {
		return content;
	}
	public BoardVO setContent(String content) {
		this.content = content;
		return this;
	}
	public String getIsActive() {
		return isActive;
	}
	public BoardVO setIsActive(String isActive) {
		this.isActive = isActive;
		return this;
	}
}
