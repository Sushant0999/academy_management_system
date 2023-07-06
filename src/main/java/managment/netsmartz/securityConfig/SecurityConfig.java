package managment.netsmartz.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeHttpRequests(
//                        (authorize) ->
//                        {
//                            try {
//                                authorize.requestMatchers("/admin/**").authenticated()
//                                .requestMatchers("/student/**").authenticated()
//                                .anyRequest().permitAll().and().formLogin().loginPage("/login");
//                            } catch (Exception e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//                )
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/admin/**").authenticated().requestMatchers("/student/**").authenticated().anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder().username("user").password(passwordEncoder.encode("user")).roles("USER")
                .build();
        UserDetails admin = User.builder().username("admin").password(passwordEncoder.encode("admin")).roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }

}
