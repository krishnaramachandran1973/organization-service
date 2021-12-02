package com.cts.organization.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cts.organization.model.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, String> {
	public Optional<Organization> findById(String id);
}
