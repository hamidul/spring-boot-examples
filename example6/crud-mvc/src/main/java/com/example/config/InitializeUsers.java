package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.CollectionUtils;

import com.example.entity.Authorities;
import com.example.entity.Users;
import com.example.repository.AuthorityRepository;
import com.example.repository.UsersRepository;

@Configuration
public class InitializeUsers {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	CommandLineRunner initDatabase() {
		return args -> {

			var authorities = authorityRepository.findAll();

			if (CollectionUtils.isEmpty(authorities)) {
				var userRole = Authorities.builder()
						.authority("ROLE_USER")
						.build();
				authorityRepository.saveAndFlush(userRole);
				var devRole = Authorities.builder()
						.authority("ROLE_DEVELOPER")
						.build();
				authorityRepository.saveAndFlush(devRole);
				var adminRole = Authorities.builder()
						.authority("ROLE_ADMIN")
						.build();
				authorityRepository.saveAndFlush(adminRole);

			}

			var authorities1 = authorityRepository.findAll();
			authorities1.forEach(
					authority -> {

						if (authority.getAuthority().equalsIgnoreCase("ROLE_DEVELOPER")) {
							if (userRepository.findByUsername("developer").isEmpty()) {
								var user1 = Users.builder().username("developer")
										.password(bCryptPasswordEncoder.encode("developer"))
										.authority(authority)
										.build();

								userRepository.save(user1);
							}

						} else if (authority.getAuthority().equalsIgnoreCase("ROLE_USER")) {

							if (userRepository.findByUsername("user").isEmpty()) {
								var user2 = Users.builder().username("user")
										.password(bCryptPasswordEncoder.encode("user"))
										.authority(authority)
										.build();

								userRepository.save(user2);
							}

						} else if (authority.getAuthority().equalsIgnoreCase("ROLE_ADMIN")) {
							if (userRepository.findByUsername("admin").isEmpty()) {
								var user3 = Users.builder().username("admin")
										.password(bCryptPasswordEncoder.encode("admin"))
										.authority(authority)
										.build();

								userRepository.save(user3);
							}

						}

					}

			);

		};
	}
}
