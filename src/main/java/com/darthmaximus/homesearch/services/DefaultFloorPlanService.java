package com.darthmaximus.homesearch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darthmaximus.homesearch.config.DataConfig;
import com.darthmaximus.homesearch.models.FloorPlan;

@Service
public class DefaultFloorPlanService implements FloorPlanService {
	@Autowired private DataConfig data;

	@Override
	public List<FloorPlan> findAll() {
		return data.getFloorPlans();
	}

	@Override
	public FloorPlan findByName(String name) {
		return data.getFloorPlans().stream().filter(f -> f.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	@Override
	public FloorPlan toggle(String name, boolean enable) {
		FloorPlan floorPlan = findByName(name);
		floorPlan.setEnabled(enable);
		return floorPlan;
	}
}
