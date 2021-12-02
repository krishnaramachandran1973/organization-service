package com.cts.organization.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.organization.events.source.SimpleSourceBean;
import com.cts.organization.model.Organization;
import com.cts.organization.repository.OrganizationRepository;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationRepository repository;

	@Autowired
	SimpleSourceBean simpleSourceBean;

	public Organization findById(String id) {
		Optional<Organization> opt = repository.findById(id);
		simpleSourceBean.publishOrganizationChange("GET", opt.get()
				.getId());
		return (opt.isPresent()) ? opt.get() : null;
	}

	public Organization create(Organization organization) {
		organization.setId(UUID.randomUUID()
				.toString());
		organization = repository.save(organization);
		simpleSourceBean.publishOrganizationChange("SAVE", organization.getId());
		return organization;

	}

	public void update(Organization organization) {
		repository.save(organization);
		simpleSourceBean.publishOrganizationChange("UPDATE", organization.getId());
	}

	public void delete(String id) {
		repository.deleteById(id);
		simpleSourceBean.publishOrganizationChange("DELETE", id);
	}

}
