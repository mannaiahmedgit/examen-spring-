package tn.suptech.examenahmedmannainumero_sujetv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.examenahmedmannainumero_sujetv.entities.Semestre;


@Repository
public interface SemestreRepository extends JpaRepository<Semestre,Long> {
}
