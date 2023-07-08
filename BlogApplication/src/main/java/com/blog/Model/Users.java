package com.blog.Model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotBlank(message = "Name can't be blank")
	@NotNull(message = "Name can't be null")
//	@Pattern(regexp = "[A-Za-z]", message = "Name will contain only character")
	private String name;
	
	@Past(message = "Date should be in past only")
	private LocalDateTime dateofbirth;
	
	@Email(message = "email is not in format")
	@Column(unique = true)
	private String email;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\w\\s]).{6,12}$", message="Invalid password")
	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank(message = "Password can't be blank")
	@NotNull(message = "Password can't be null")
	private String password;
	
	@NotBlank(message = "Address can't be blank")
	@NotNull(message = "Address can't be null")
	private String address;
	
}
