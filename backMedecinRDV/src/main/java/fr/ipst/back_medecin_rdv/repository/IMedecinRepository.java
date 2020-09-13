package fr.ipst.back_medecin_rdv.repository;

import fr.ipst.back_medecin_rdv.entities.MedecinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedecinRepository extends JpaRepository<MedecinEntity, Long> {

    List<MedecinEntity> findByVille(@Param("ville") String ville);

    List<MedecinEntity> findByVilleAndNomOrVilleAndSpecialisation(@Param("ville") String ville, @Param("nom") String nom,@Param("ville") String ville2, @Param("specialisation") String specialisation);
}
