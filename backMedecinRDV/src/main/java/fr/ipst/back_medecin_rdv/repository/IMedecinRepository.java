package fr.ipst.back_medecin_rdv.repository;

import fr.ipst.back_medecin_rdv.entities.MedecinEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedecinRepository extends JpaRepository<MedecinEntity, Long> {

    @Query("select u from medecin u where u.ville = :ville")
    List<MedecinEntity> findByVille(@Param("ville") String ville);

//    @Query("select u from medecin u where (u.ville = :ville and u.nom = :nom) or (u.ville = :ville and n.specialisation = :specialisation)")
//    List<MedecinEntity> findByVilleAndNomOrSpecialisation(@Param("ville") String ville, @Param("nom") String nom, @Param("specialisation") String specialisation);
    
        /* A ESSAYER 
        @Query(value = "select u from medecin u where (u.ville = :ville and u.nom = :nom) or (u.ville = :ville and n.specialisation = :specialisation", nativeQuery = true)
        */

    List<MedecinEntity> findByVilleAndNomOrVilleAndSpecialisation(@Param("ville") String ville, @Param("nom") String nom,@Param("ville") String ville2, @Param("specialisation") String specialisation);

}
