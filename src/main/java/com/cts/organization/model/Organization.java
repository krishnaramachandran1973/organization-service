package com.cts.organization.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Organization {

	@Id
	private String id;

	private String name;

	private String contactName;

	private String contactEmail;

	private String contactPhone;

}
