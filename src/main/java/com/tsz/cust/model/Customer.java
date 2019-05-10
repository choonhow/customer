package com.tsz.cust.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer extends AuditModel {
    @Id
    @GeneratedValue(generator = "customer_generator")
    @SequenceGenerator(
            name = "customer_generator",
            sequenceName = "customer_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String firstName;

    @Size(min = 3, max = 100)
    private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    
    // Getters and Setters (Omitted for brevity)
}