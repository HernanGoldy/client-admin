package com.bit.client_admin.repository;

import com.bit.client_admin.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.nombreCalle = :nombreCalle" +
            " AND c.numeroCalle = :numeroCalle" +
            " AND c.piso = :piso" +
            " AND c.departamento = :departamento" +
            " AND c.nombreEdificio = :nombreEdificio")
    List<Client> existe(@Param("nombreCalle") String calle,
                        @Param("numeroCalle") String numero,
                        @Param("piso") String piso,
                        @Param("departamento") String departamento,
                        @Param("nombreEdificio") String nombreEdificio);
}
