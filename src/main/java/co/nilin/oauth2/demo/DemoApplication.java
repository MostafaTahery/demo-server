package co.nilin.oauth2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@EnableResourceServer
@RestController
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/validate")
	public Principal validate(Principal user){
		return user;
	}
	/*@Configuration
	protected static class AuthenticationManagerConfiguration extends GlobalAuthenticationConfigurerAdapter{
		@Override
		public void init(AuthenticationManagerBuilder auth) throws Exception{
			auth.inMemoryAuthentication()
					.withUser("ali")
					.password("gholi")
					.roles("USER");
		}
	}*/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

