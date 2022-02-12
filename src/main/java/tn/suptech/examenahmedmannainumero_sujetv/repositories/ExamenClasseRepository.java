package tn.suptech.examenahmedmannainumero_sujetv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenahmedmannainumero_sujetv.entities.ExamenClasse;
import tn.suptech.examenahmedmannainumero_sujetv.entities.User;

@Repository
public interface ExamenClasseRepository extends JpaRepository<ExamenClasse,Long> {
}
