package com.zalominimenu.springboot.controller;

import com.zalominimenu.springboot.configuration.ServerConfiguration;
import com.zalominimenu.springboot.dto.HealthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class HealthController {
	private final ServerConfiguration serverConfiguration;

	public HealthController(ServerConfiguration serverConfiguration) {
		this.serverConfiguration = serverConfiguration;
	}

	@GetMapping("/health")
	public ResponseEntity<HealthResponse> health() {

		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = dateFormat. format(currentDate);

		return ResponseEntity.ok(new HealthResponse(
				"Mini Zalo App",
					"OK",
				serverConfiguration.getVersion(),
				currentDateTime,
				serverConfiguration.getEnvironment()
				));
	}

}
