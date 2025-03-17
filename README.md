# Expense-Tracker

The Expense Tracker application is a backend service built using Spring Boot and MongoDB. It allows users to manage their expenses efficiently. The project implements features such as user management, authentication, and expense categorization.

# Spring Security
@EnableWebSecurity is a marker annotation. It allows Spring to find (it's a @Configuration and, therefore, @Component) and automatically apply the class to the global WebSecurity.
Used with @Configuration: The class annotated with @EnableWebSecurity is usually marked with @Configuration to define Spring beans.
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults());
        return http.build();
    }

}
