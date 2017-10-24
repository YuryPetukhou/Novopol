package lv.javaguru.novopol.logic.api.news;

import java.time.LocalDate;
import java.util.List;

public class ListNewsRequest {
	private String author;
	private LocalDate exactDate;
	private LocalDate startDate;
	private LocalDate finishDate;
	private List<String> keywords;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDate getExactDate() {
		return exactDate;
	}
	public void setExactDate(LocalDate exactDate) {
		this.exactDate = exactDate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

}
