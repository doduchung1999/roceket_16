package Abstraction;

import java.util.ArrayList;
import java.util.Arrays;

public class News implements INews {

	@Override
	public void Display() {
		System.out.println("news " + title + publishDate + authur + content + averageRate + rates);
	}


	@Override
	public float Calculate() {
		averageRate = (float) ((rates[0] + rates[1] + rates[2]) / 3);
		return averageRate;
	}

	private int id;
	private String title, publishDate, authur, content;
	private float averageRate;
	private int[] rates;

	public News(int id, String title, String publishDate, String authur, String content, int[] rates) {
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.authur = authur;
		this.content = content;
		this.averageRate = averageRate;
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", publishDate=" + publishDate + ", authur=" + authur
				+ ", content=" + content + ", averageRate=" + averageRate + ", rates=" + Arrays.toString(rates) + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthur() {
		return authur;
	}

	public void setAuthur(String authur) {
		this.authur = authur;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getAverageRate() {
		return averageRate;
	}

	public int[] getRates() {
		return rates;
	}

	public void setRates(int[] rates) {
		this.rates = rates;
	}

}
