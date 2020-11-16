package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Profile;
import com.example.demo.service.ProfileService;

@RestController
public class ProfileController {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello jaeger";
		
	}
	
	/* @RequestMapping("/chaining")
	    public String chaining() {
	        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/hello", String.class);
	        return "Chaining + " + response.getBody();
	    }*/

    
	@Autowired
	private ProfileService service;
	
	@PostMapping("/addProfile")
	public Profile addProfile(@RequestBody Profile profile) {
		System.out.println("from addprofile" + profile.toString());
		return service.saveProfile(profile);
	}
	
	@PostMapping("/addProfiles")
	public List<Profile> addProfiles(@RequestBody List<Profile> profiles){
		return service.saveProfiles(profiles);
	}
	
	@GetMapping("/profiles")
	public List<Profile> findAllProfiles(){
		return service.getProfiles();
		
	}
	
	@GetMapping("/profileById/{id}")
	public Profile findProfileById(@PathVariable int id) {
		return service.getProfileById(id);
	}
	
	@GetMapping("/profile/{name}")
	public Profile findProfileByName(@PathVariable String name) {
		return service.getProfileByName(name);
	}
	
	/*@PutMapping("/update")
	public Profile updateProfile(@RequestBody Profile profile) {
		return service.updateProfile(profile);
	}*/
	
	@DeleteMapping("/delete/{id}")
	public String deleteProfile(@PathVariable int id) {
		return service.deleteProfile(id);
	}
	
}
