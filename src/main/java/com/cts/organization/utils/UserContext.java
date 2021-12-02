package com.cts.organization.utils;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class UserContext {

	public static final String CORRELATION_ID = "tmx-correlation-id";
	public static final String ORG_ID = "tmx-org-id";

	private String correlationId = new String();
	private String orgId = new String();

}
