package fr.ipst.back_medecin_rdv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("fr.ipst.back_medecin_rdv.repository")
public class BackMedecinRdvApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackMedecinRdvApplication.class, args);
    }

}
