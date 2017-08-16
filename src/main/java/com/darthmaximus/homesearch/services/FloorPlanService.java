package com.darthmaximus.homesearch.services;

import java.util.List;

import com.darthmaximus.homesearch.models.FloorPlan;

public interface FloorPlanService {
	public List<FloorPlan> findAll();
	public FloorPlan findByName(String name);
	public FloorPlan toggle(String name, boolean enable);
}
