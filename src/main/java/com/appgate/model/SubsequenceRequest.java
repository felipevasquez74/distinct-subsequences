package com.appgate.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SubsequenceRequest {
	@NotNull(message = "Source cannot be null.")
	@NotEmpty(message = "Source cannot be empty.")
	@Size(min = 1, max = 100, message = "Source must be between 1 and 100 characters.")
	private String source;

	@NotNull(message = "Target cannot be null.")
	@NotEmpty(message = "Target cannot be empty.")
	@Size(min = 1, max = 100, message = "Target must be between 1 and 100 characters.")
	private String target;

	public SubsequenceRequest() {
	}

	public SubsequenceRequest(String source, String target) {
		this.source = source;
		this.target = target;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
