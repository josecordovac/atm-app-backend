package com.atm.web.services.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ATM_PRODUCT", schema = "public")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long id;

    @Column(name = "PRODUCT_NAME", unique = true)
    private String name;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String description;
    
    @Column(name = "PRODUCT_IMAGE")
    private String image;

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}