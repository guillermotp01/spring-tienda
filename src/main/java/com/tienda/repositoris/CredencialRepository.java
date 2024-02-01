package com.tienda.repositoris;


import ch.qos.logback.core.net.server.Client;
import com.tienda.model.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredencialRepository extends JpaRepository<Credencial,Long> {
    Credencial findByEmail(String email);

    Credencial getReferenceByEmail(String email);
}
