// package com.harald.jwtauth.configuration;
//
// import org.springframework.boot.ApplicationArguments;
// import org.springframework.boot.ApplicationRunner;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.io.ClassPathResource;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
//
// import java.util.Objects;
//
// @Configuration
// public class DatabaseInitializer implements ApplicationRunner {
//
//     private final JdbcTemplate jdbcTemplate;
//
//     public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
//         this.jdbcTemplate = jdbcTemplate;
//     }
//     @Override
//     public void run(ApplicationArguments args) throws Exception {
//         // ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
//         // resourceDatabasePopulator.addScript(new ClassPathResource("drop-db.sql"));
//         // resourceDatabasePopulator.addScript(new ClassPathResource("schema.sql"));
//         // resourceDatabasePopulator.addScript(new ClassPathResource("data.sql"));
//
//         // resourceDatabasePopulator.execute(Objects.requireNonNull(jdbcTemplate.getDataSource()));
//     }
//
// }
