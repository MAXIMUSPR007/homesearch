package com.darthmaximus.homesearch.models;

import java.util.LinkedList;
import java.util.List;

public class Location {
	private String name;
	private List<Community> communities = new LinkedList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Community> getCommunities() {
		return communities;
	}
	public void setCommunities(List<Community> communities) {
		this.communities = communities;
	}
	
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Location [name=").append(name).append(", communities=")
				.append(communities != null ? communities.subList(0, Math.min(communities.size(), maxLen)) : null)
				.append("]");
		return builder.toString();
	}
}
