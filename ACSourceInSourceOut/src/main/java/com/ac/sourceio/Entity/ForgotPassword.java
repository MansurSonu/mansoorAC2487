package com.ac.sourceio.Entity;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="forgot_password")
public class ForgotPassword {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer forgotPasswordId;
	private String createNewPassword;
	private String confirmNewPassString;
}
