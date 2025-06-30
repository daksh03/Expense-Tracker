# Expense-Tracker

The Expense Tracker application is a backend service built using Spring Boot and MongoDB. It allows users to manage their expenses efficiently. The project implements features such as user management, authentication, and expense categorization.

# Spring Security
@EnableWebSecurity is a marker annotation. It allows Spring to find (it's a @Configuration and, therefore, @Component) and automatically apply the class to the global WebSecurity.
Used with @Configuration: The class annotated with @EnableWebSecurity is usually marked with @Configuration to define Spring beans.
```
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
```
## Different Query Types in Spring Data Repositories

- ## 1. Simple Queries:
Simple queries involve methods derived from Spring Data repository interfaces, enabling basic CRUD operations.
```
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Simple query for finding products by category
    List<Product> findByCategory(String category);
}
```
- ## 2. Query Methods:
Spring Data enables the creation of custom query methods using method naming conventions, supporting parameterized queries.
```
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Query method with parameters for finding products by name and price
    List<Product> findByNameAndPrice(String name, double price);
}
```
- ## 3. JPQL Queries:
Java Persistence Query Language allows developers to craft more complex queries using object-oriented concepts.
```
public interface OrderRepository extends JpaRepository<Order, Long> {
    // JPQL query for finding orders by status
    @Query("SELECT o FROM Order o WHERE o.status = :status")
    List<Order> findOrdersByStatus(@Param("status") String status);
}
```
- ## 4. Native Queries:
Native queries permit the execution of SQL queries directly, providing flexibility for intricate database-specific operations.
```
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Native query for finding orders by customer ID
    @Query(value = "SELECT * FROM orders WHERE customer_id = :customerId", nativeQuery = true)
    List<Order> findOrdersByCustomerId(@Param("customerId") Long customerId);
}
```
- ## 5. Specifications:
Spring Data Specifications allow for the creation of complex and reusable query predicates.
```
public class OrderSpecifications {

    public static Specification<Order> hasComplexCriteria(/* Parameters as needed */) {
        return (root, query, criteriaBuilder) -> {
            // Define complex query logic using criteriaBuilder
            return criteriaBuilder.and(/* Complex criteria predicates */);
        };
    }
}
```
