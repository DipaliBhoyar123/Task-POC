package com.test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

	public class Adult implements Serializable {

	    private static final long serialVersionUID = 1L;

	    private String firstName;
	    private String lastName;
	    private Integer age;

	    /**
	     * This class has a constructor validation that restricts illegal Adult instances which doesn't
	     * work during deserialization. Modify the code in this file so that we can also restrict illegal
	     * Adult instances during deserialization.
	     */
	    public Adult(String firstName, String lastName, Integer age) {
	        validate(firstName, lastName, age);
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.age = age;
	    }

	    private void validate(String firstName, String lastName, Integer age) {
	        if (StringUtils.isBlank(firstName) || StringUtils.isBlank(lastName)) {
	            throw new IllegalArgumentException("Firstname or Lastname CANNOT be blank.");
	        }

	        if (Objects.isNull(age) || age < 18) {
	            throw new IllegalArgumentException("Inappropriate Age for an Adult.");
	        }
	    }

	    private void writeObject(ObjectOutputStream out) throws IOException {
	        out.defaultWriteObject();
	    }

	    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
	        in.defaultReadObject();
	        validate(firstName, lastName, age);
	    }
	}

