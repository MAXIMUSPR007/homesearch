package com.darthmaximus.homesearch.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.darthmaximus.homesearch.models.FloorPlan;

@Component
@ConfigurationProperties
public class DataConfig {
	private List<FloorPlan> floorPlans = new LinkedList<>();

	public List<FloorPlan> getFloorPlans() {
		return floorPlans;
	}
	public void setFloorPlans(List<FloorPlan> floorPlans) {
		this.floorPlans = floorPlans;
	}
}
