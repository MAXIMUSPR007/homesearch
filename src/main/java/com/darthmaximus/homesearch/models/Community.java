package com.darthmaximus.homesearch.models;

import java.util.LinkedList;
import java.util.List;

public class Community {
	private String name;
	private List<FloorPlan> floorPlans = new LinkedList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FloorPlan> getFloorPlans() {
		return floorPlans;
	}
	public void setFloorPlans(List<FloorPlan> floorPlans) {
		this.floorPlans = floorPlans;
	}
	
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Community [name=").append(name).append(", floorPlans=")
				.append(floorPlans != null ? floorPlans.subList(0, Math.min(floorPlans.size(), maxLen)) : null)
				.append("]");
		return builder.toString();
	}
}
