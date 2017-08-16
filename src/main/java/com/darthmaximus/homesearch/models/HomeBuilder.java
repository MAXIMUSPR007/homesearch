package com.darthmaximus.homesearch.models;

import java.util.LinkedList;
import java.util.List;

public class HomeBuilder {
	private String name;
	private List<Location> locations = new LinkedList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("HomeBuilder [name=").append(name).append(", locations=")
				.append(locations != null ? locations.subList(0, Math.min(locations.size(), maxLen)) : null)
				.append("]");
		return builder.toString();
	}
}
