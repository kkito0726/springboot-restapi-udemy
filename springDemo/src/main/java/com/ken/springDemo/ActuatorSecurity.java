package com.ken.springDemo;

//@Configuration
//@EnableWebSecurity
public class ActuatorSecurity {

	//	@Bean
	//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	//		http.authorizeHttpRequests()
	//				.requestMatchers("/", "/items", "/items/{itemId}").permitAll()
	//				.requestMatchers("/actuator/**").hasRole("ADMIN")
	//				.anyRequest().denyAll().anyRequest().authenticated();
	//		return http.build();
	//	}

	//
	//	@Bean
	//	public WebSecurityCustomizer webSecurityCustomizer() {
	//		return (web) -> web.ignoring().requestMatchers("/actuator/helth");
	//	}
	//
	//	@Bean
	//	InMemoryUserDetailsManager userDetailsService() {
	//		UserDetails user = User.withUsername("admin")
	//				.password("{noop}admin")
	//				.roles("ADMIN")
	//				.build();
	//		return new InMemoryUserDetailsManager(user);
	//	}
}
