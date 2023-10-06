package tw.ispan.eeit168;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tw.ispan.eeit168.company.util.SecurityProperties;

@Configuration
@EnableTransactionManagement
public class AppConfig {
	@Value("${login.maxAttempts}")
	private int maxLoginAttempts;

	@Value("${login.lockoutDurationMinutes}")
	private int lockoutDurationMinutes;

	@Bean
	public SecurityProperties customSecurityProperties() {
		SecurityProperties securityProperties = new SecurityProperties();
		securityProperties.setMaxLoginAttempts(maxLoginAttempts);
		securityProperties.setLockoutDurationMinutes(lockoutDurationMinutes);
		return securityProperties;
	}
}
