package com.example.demo.service;
import com.example.demo.entity.Profile;
import com.example.demo.repository.ProfileRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

//import com.example.demo.repository.ProfileRepo;


@Service
public class ProfileService {

	@Autowired
	private ProfileRepo repository;
	//post method
	public Profile saveProfile(Profile profile) {
		System.out.println(profile.toString());
		 return repository.save(profile);
		 
	}
	
	public List<Profile> saveProfiles(List<Profile> profiles) {
		return repository.saveAll(profiles);
	}
	//getmethods
	public List<Profile> getProfiles(){
		return repository.findAll();
		
	}
	
	public Profile getProfileById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Profile getProfileByName(String name) {
		return repository.findByName(name);
	}
	
	//delete
	public String deleteProfile(int id) {
		repository.deleteById(id);
		return "profile removed";
	}
	
	//update
	/*public Profile updateProfile(Profile profile) {
		Profile existingProfile=repository.findById(profile.getId()).orElse(null);
		existingProfile.setName(profile.getName());
		existingProfile.setLanguage(profile.getLanguage());
		existingProfile.setMail_id(profile.getMail_id());
		return repository.save(existingProfile);
	
	}*/
}

