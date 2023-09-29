package com.example.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This demo demonstrate how to load active profile The active profile can be
 * set in application.properties using the property spring.profiles.active
 * 
 * For example to set current profile to dev we can set like below
 * spring.profiles.active=dev
 * 
 * It's wise to externalize this property. Because in real life our application
 * will run different environment like dev, test, prod etc.So for each
 * environment we can't set the active profile manually.
 * 
 * To overcome this situation, set spring.profiles.active as environment
 * variable. We can read it using System.getenv and set the active profile using
 * System.setProperty("spring.profiles.active", "your-profile-name") which is
 * demonstrated below.
 * 
 * 
 * Another problem, after changing the environment variable we may need to
 * restart the computer. To overcome this we can set the active profile in the
 * run configuration->enviroment in the STS. In this window set the same
 * environment variable which was set for windows environment variable.
 */
@SpringBootApplication
public class ProfileDemoApplication {

	public static void main(String[] args) {
		// Read the environment property spring.profiles.active for active profiles
		String activeProfiles = System.getenv("spring.profiles.active");
		System.out.println("#########activeProfiles#############" + activeProfiles);

		// If the system property is not set, you can provide a default value
		//In this case application.properties will act like a default profile
		if (activeProfiles == null) {
			activeProfiles = "default";
		}

		// Set the active profiles
		System.setProperty("spring.profiles.active", activeProfiles);
		SpringApplication.run(ProfileDemoApplication.class, args);
	}

}
