package com.bit.client_admin.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private LocalDate fechaAlta;
    private Integer numeroCliente;
    private String apellidos;
    private String nombres;
    private String nombreCalle;
    private Integer numeroCalle;
    private String piso;
    private String departamento;
    private String nombreEdificio;
}
