package com.mso.consulta.seguros.v1.repository;

import com.mso.consulta.seguros.v1.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroRepository extends JpaRepository<Seguro, Integer> {
}
