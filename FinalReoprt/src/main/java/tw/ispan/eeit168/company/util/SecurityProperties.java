package tw.ispan.eeit168.company.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecurityProperties {
	 @Value("${login.maxAttempts}")
	    private int maxLoginAttempts;

	    @Value("${login.lockoutDurationMinutes}")
	    private int lockoutDurationMinutes;

	    public int getMaxLoginAttempts() {
	        return maxLoginAttempts;
	    }

	    public void setMaxLoginAttempts(int maxLoginAttempts) {
	        this.maxLoginAttempts = maxLoginAttempts;
	    }

	    public int getLockoutDurationMinutes() {
	        return lockoutDurationMinutes;
	    }

	    public void setLockoutDurationMinutes(int lockoutDurationMinutes) {
	        this.lockoutDurationMinutes = lockoutDurationMinutes;
	    }

}
