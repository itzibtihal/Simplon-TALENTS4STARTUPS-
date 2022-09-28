package stcManager.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import stcManager.securityJwt.JwtRequestFilter;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	

	
	private final UserDetailsService jwtUserDetailsService ;
	private final JwtRequestFilter jwtRequestFilter;
	
	
	
	public WebSecurityConfig(UserDetailsService jwtUserDetailsService, JwtRequestFilter jwtRequestFilter) {
			super();
			this.jwtUserDetailsService = jwtUserDetailsService;
			this.jwtRequestFilter = jwtRequestFilter;
		}

//	@Bean
//	public AuthenticationProvider authProvider()
//	{
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		provider.setPasswordEncoder(passwordEncoder());
//		return provider;
//	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
//    @Bean 
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		httpSecurity.csrf().disable()
				// dont authenticate this particular request
				.authorizeRequests().antMatchers("/authenticate").permitAll()
				// all other requests need to be authenticated
				//anyRequest().authenticated()
				.and()
				// make sure we use stateless session; session won't be used to
				// store user's state.
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		httpSecurity.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/STCManager/**").hasAuthority("ADMIN")
		.antMatchers("/save").hasAuthority("ADMIN")
		.antMatchers("/delete/{roll}").hasAuthority("ADMIN")
		.antMatchers("/editExercice/{roll}").hasAuthority("ADMIN")
		.antMatchers("/edit/{roll}").hasAnyAuthority("ADMIN","RESPONSABLE")
		.antMatchers("/list").hasAnyAuthority("ADMIN","RESPONSABLE","PARTICIPENT")
		.antMatchers("/list/{roll}").hasAnyAuthority("ADMIN","RESPONSABLE","PARTICIPENT")
		.anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
	  //.formLogin().loginPage("/login").permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403");
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		
//		http.authorizeRequests()
//				.antMatchers("/").permitAll()
//				.antMatchers("/STCManager/**").hasAuthority("ADMIN")
//				.antMatchers("/save").hasAuthority("ADMIN")
//				.antMatchers("/delete/{roll}").hasAuthority("ADMIN")
//				.antMatchers("/editExercice/{roll}").hasAuthority("ADMIN")
//				.antMatchers("/edit/{roll}").hasAnyAuthority("ADMIN","RESPONSABLE")
//				.antMatchers("/list").hasAnyAuthority("ADMIN","RESPONSABLE","PARTICIPENT")
//				.antMatchers("/list/{roll}").hasAnyAuthority("ADMIN","RESPONSABLE","PARTICIPENT")
//				.anyRequest().authenticated()
//				.and()
//				.formLogin().permitAll()
//			  //.formLogin().loginPage("/login").permitAll()
//				.and()
//				.logout().permitAll()
//				.and()
//				.exceptionHandling().accessDeniedPage("/403");
//	
//	}
	
}
