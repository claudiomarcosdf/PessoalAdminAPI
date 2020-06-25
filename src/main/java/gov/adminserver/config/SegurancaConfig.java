package gov.adminserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;


@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SegurancaConfig {
     
	@Bean
    MapReactiveUserDetailsService userDetailService() {
		UserDetails user = User.builder()
				.username("usuario")
				.password(passwordEncoder().encode("123"))
				.roles("USER")
				.build();
		
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("coringa"))
                .roles("ADMIN", "USER")
                .build();		
		
		return new MapReactiveUserDetailsService(user, admin);
	}
	
    @Bean
    public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
         http.authorizeExchange()
        		.pathMatchers("/login", "/logout").permitAll()
				.pathMatchers(HttpMethod.GET, "/pessoal").hasRole("USER")
                .pathMatchers(HttpMethod.POST, "/pessoal/**").hasRole("ADMIN")
                .pathMatchers(HttpMethod.DELETE, "/pessoal/**").hasRole("ADMIN")
                .pathMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				//.pathMatchers("/users/{user}/**").access(this::currentUserMatchesPath)
				.anyExchange().authenticated()
				.and()
				.csrf().disable()
				.httpBasic().and()
				.formLogin();	
         
         return http.build();
        	
    }	
    
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

//EXEMPLO ENCRIPTAR SENHA DE USUÁRIO
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	 
//	@Override
//	public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
//	    if (emailExist(accountDto.getEmail())) {
//	        throw new EmailExistsException(
//	          "There is an account with that email adress:" + accountDto.getEmail());
//	    }
//	    User user = new User();
//	    user.setFirstName(accountDto.getFirstName());
//	    user.setLastName(accountDto.getLastName());
//	     
//	    user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//	     
//	    user.setEmail(accountDto.getEmail());
//	    user.setRole(new Role(Integer.valueOf(1), user));
//	    return repository.save(user);
//	}	

}
