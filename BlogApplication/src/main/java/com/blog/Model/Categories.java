package com.blog.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryID;
	
	@NotBlank(message = "Category name can't be blank")
	@NotNull(message = "Category name can't be null")
	private String categoryName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categories")
	List<Posts> posts;
	
}
