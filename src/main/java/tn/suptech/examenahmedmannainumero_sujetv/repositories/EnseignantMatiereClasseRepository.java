package tn.suptech.examenahmedmannainumero_sujetv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenahmedmannainumero_sujetv.entities.EnseignantMatiereClass;
import tn.suptech.examenahmedmannainumero_sujetv.entities.User;

@Repository
public interface EnseignantMatiereClasseRepository extends JpaRepository<EnseignantMatiereClass,Long> {
}
