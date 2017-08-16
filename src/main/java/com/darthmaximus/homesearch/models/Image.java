package com.darthmaximus.homesearch.models;

public class Image {
	private String url;
	private String group;
	private boolean enabled;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Image [url=").append(url).append(", group=").append(group).append(", enabled=").append(enabled)
				.append("]");
		return builder.toString();
	}
}
