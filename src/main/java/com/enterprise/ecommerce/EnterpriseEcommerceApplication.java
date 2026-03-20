package com.enterprise.ecommerce;

import com.enterprise.ecommerce.entity.Role;
import com.enterprise.ecommerce.entity.User;
import com.enterprise.ecommerce.repository.RoleRepository;
import com.enterprise.ecommerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class EnterpriseEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseEcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository,
						  RoleRepository roleRepository,
						  BCryptPasswordEncoder passwordEncoder) {
		return args -> {

			Role adminRole = roleRepository.findAll()
					.stream()
					.filter(role -> role.getName().equals("ADMIN"))
					.findFirst()
					.orElseGet(() -> {
						Role role = new Role();
						role.setName("ADMIN");
						return roleRepository.save(role);
					});

			roleRepository.findAll()
					.stream()
					.filter(role -> role.getName().equals("USER"))
					.findFirst()
					.orElseGet(() -> {
						Role role = new Role();
						role.setName("USER");
						return roleRepository.save(role);
					});

			User existingAdmin = userRepository.findByEmail("admin@email.com");

			if (existingAdmin == null) {
				User adminUser = new User();
				adminUser.setName("Admin");
				adminUser.setEmail("admin@email.com");
				adminUser.setPassword(passwordEncoder.encode("admin123"));
				adminUser.setRoles(Set.of(adminRole));

				userRepository.save(adminUser);
			}
		};
	}
}
