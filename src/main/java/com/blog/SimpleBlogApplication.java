package com.blog;

import com.blog.repository.usersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = usersRepository.class)
public class SimpleBlogApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SimpleBlogApplication.class, args);
	}

}
