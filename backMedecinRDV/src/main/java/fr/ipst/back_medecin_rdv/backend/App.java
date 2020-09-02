package fr.ipst.back_medecin_rdv.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"fr.ipst.back_medecin_rdv.exceptions", "fr.ipst.back_medecin_rdv.controller", "fr.ipst.back_medecin_rdv.mapper", "fr.ipst.back_medecin_rdv.services", "fr.ipst.back_medecin_rdv.dto", "fr.ipst.back_medecin_rdv.backend"})
@EntityScan("fr.ipst.back_medecin_rdv.entities")
@EnableJpaRepositories(basePackages = "fr.ipst.back_medecin_rdv.repository")

public class App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(App.class);
    }
}
