package mx.com.itp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@SuppressWarnings("deprecation")
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add users for IN MEMORY AUTHENTICATION
				
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test123").roles("STUDENT"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
			http.authorizeRequests()
				.antMatchers("/showHomePage/**").hasRole("STUDENT")
				.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/Login/LoginPage")
					.loginProcessingUrl("/authenticateUser")
					.permitAll()
					.and()
					.logout().permitAll()
					.and()
					.exceptionHandling().accessDeniedPage("");
			
		
	}
	
	
	
	
	
}
