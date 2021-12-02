package com.cts.organization.events.source;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.cts.organization.events.model.OrganizationChangeModel;
import com.cts.organization.utils.UserContextHolder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class SimpleSourceBean {
	private final Source source;

	public void publishOrganizationChange(String action, String organizationId) {
		log.debug("Sending Kafka message {} for Organization Id: {}", action, organizationId);
		OrganizationChangeModel change = new OrganizationChangeModel(OrganizationChangeModel.class.getTypeName(),
				action, organizationId, UserContextHolder.getContext()
						.getCorrelationId());

		source.output()
				.send(MessageBuilder.withPayload(change)
						.build());
	}
}