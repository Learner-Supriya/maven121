package com.example.database.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.database.Response.WebResponse;

@RestController
@RequestMapping("/office")
public class WebController {
	
	@RequestMapping("/accessDenied")
	public ResponseEntity<WebResponse> accessDenied()
	{
		WebResponse response = new WebResponse(false, "Unauthenticated Access !");
		return ResponseEntity.badRequest().body(response);
	}

}
