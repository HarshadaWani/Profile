package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROFILE_TBL" )


public class Profile {
	
	@Id
	@GeneratedValue
	
	private int id;
	private String name;
	private String language;
	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", language=" + language + ", mail_id=" + mail_id + "]";
	}
	private String mail_id;

}
