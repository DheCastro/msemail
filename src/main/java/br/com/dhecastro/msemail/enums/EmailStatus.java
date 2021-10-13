package br.com.dhecastro.msemail.enums;

public enum EmailStatus {

	PROCESSING("Processing"), 
	SENT("Sent"), 
	ERROR("Error");

	private String description;

	EmailStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
