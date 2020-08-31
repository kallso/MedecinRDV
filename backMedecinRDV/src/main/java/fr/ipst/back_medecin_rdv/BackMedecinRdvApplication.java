package fr.ipst.back_medecin_rdv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class, basePackages = "fr.ipst.back_medecin_rdv.repository")
@ComponentScan({"fr.ipst.back_medecin_rdv.exceptions","fr.ipst.back_medecin_rdv.controller","fr.ipst.back_medecin_rdv.entities"})
@EntityScan("fr.ipst.back_medecin_rdv.entities")
public class BackMedecinRdvApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackMedecinRdvApplication.class, args);
    }

}
