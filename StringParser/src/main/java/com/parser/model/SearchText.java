package com.parser.model;

import java.util.List;

public class SearchText {
	private List<String> tags;

	public void setTags(List<String> input) {
		this.tags = input;
	}

	public List<String> getTags() {
		return tags;
	}

	public String toString() {
		return tags.toString();
	}

}
