package com.jlashley.business.reservation.reservationbusinessservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@EnableCircuitBreaker
public class ReservationBusinessServicesApplication {

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).groupName("RoomReservation").select()
				.apis(RequestHandlerSelectors.basePackage("com.frankmoley.business.reservation"))
				.paths(any()).build().apiInfo(new ApiInfo("Room Reservation Services",
						"A set of services to provide business processes for the Room and Reservations domains", "1.0.0", null,
						new Contact("Jacob Lashley", null, null),null, null));
	}

	public static void main(String[] args) {
		SpringApplication.run(ReservationBusinessServicesApplication.class, args);
	}
}