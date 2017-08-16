package com.darthmaximus.homesearch.models;

import java.util.LinkedList;
import java.util.List;

public class FloorPlan {
	private String name;
	private String builder;
	private String location;
	private String community;
	private Boolean enabled;
	private Double pricedFrom;
	private Integer sqFeet;
	private Integer bedrooms;
	private Integer bathrooms;
	private Integer stories;
	private Integer garageCars;
	private String url;
	private Diagram diagram;
	private List<Image> images = new LinkedList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Double getPricedFrom() {
		return pricedFrom;
	}
	public void setPricedFrom(Double pricedFrom) {
		this.pricedFrom = pricedFrom;
	}
	public Integer getSqFeet() {
		return sqFeet;
	}
	public void setSqFeet(Integer sqFeet) {
		this.sqFeet = sqFeet;
	}
	public Integer getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}
	public Integer getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}
	public Integer getStories() {
		return stories;
	}
	public void setStories(Integer stories) {
		this.stories = stories;
	}
	public Integer getGarageCars() {
		return garageCars;
	}
	public void setGarageCars(Integer garageCars) {
		this.garageCars = garageCars;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Diagram getDiagram() {
		return diagram;
	}
	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder2 = new StringBuilder();
		builder2.append("FloorPlan [name=").append(name).append(", builder=").append(builder).append(", location=")
				.append(location).append(", community=").append(community).append(", enabled=").append(enabled)
				.append(", pricedFrom=").append(pricedFrom).append(", sqFeet=").append(sqFeet).append(", bedrooms=")
				.append(bedrooms).append(", bathrooms=").append(bathrooms).append(", stories=").append(stories)
				.append(", garageCars=").append(garageCars).append(", url=").append(url).append(", diagram=")
				.append(diagram).append(", images=")
				.append(images != null ? images.subList(0, Math.min(images.size(), maxLen)) : null).append("]");
		return builder2.toString();
	}	
}
