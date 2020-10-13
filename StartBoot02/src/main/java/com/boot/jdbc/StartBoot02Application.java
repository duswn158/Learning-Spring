package com.boot.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class StartBoot02Application {

	public static void main(String[] args) {
		SpringApplication.run(StartBoot02Application.class, args);
	}
	
	// html을 찾아서 먼저 들어가지만... /로 잡앗기 때문에 전부 jsp로 강제로 넘김
	@GetMapping("/index")
	public String index() {
		return "index";
	}

}
