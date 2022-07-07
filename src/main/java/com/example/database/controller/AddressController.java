package com.example.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.Response.WebResponse;
import com.example.database.entity.Address;
import com.example.database.repository.AddressRepository;



@RestController
@RequestMapping("/address")
public class AddressController
{
	@Autowired
	private AddressRepository addressRepo;
	
	@GetMapping("/list")
	public ResponseEntity<WebResponse> listAddress()
	{
		List<Address> list = addressRepo.findAll();
		WebResponse response = new WebResponse(true, list);
		return ResponseEntity.ok(response);
	}
}