package com.example.demo;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/details")
public class DetailsController 
{
	@Autowired
	private DetailsRepository dr;

	@PostMapping
    public String addDetails(@RequestBody Details details) {
		Details obj =dr.save(details);
		if (obj != null) {
	        return "Success: Employee added successfully!";
	    } else {
	        return "Error: Failed to add employee!";
	    }
    }
	
	

    // Get all employee details
    @GetMapping
    public List<Details> getAllDetails() {
        return dr.findAll();
    }
    @DeleteMapping("/{empid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int empid) {
        if (dr.existsById(empid)) {
            dr.deleteById(empid);
            return ResponseEntity.ok("Record deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found.");
        }
    }

}
