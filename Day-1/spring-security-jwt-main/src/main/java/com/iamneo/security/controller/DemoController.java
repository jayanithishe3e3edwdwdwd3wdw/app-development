package com.iamneo.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import com.iamneo.security.entity.Model;
import com.iamneo.security.repository.ModelRepository;
import com.iamneo.security.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class DemoController {
	
	
	@Autowired
	UserRepository repo;
	@Autowired
	ModelRepository repo1;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("YOGESHKUMAR");
    }
    
    @PostMapping("/post")
    public Model create(@RequestBody Model a)
    {
    	return repo.save(a);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Model> getEmployeeById(@PathVariable String firstName) {
        Optional<Model> modelOptional = repo1.findById(firstName);
        
        return modelOptional.map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }
}
