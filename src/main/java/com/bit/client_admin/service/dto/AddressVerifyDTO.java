package com.bit.client_admin.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressVerifyDTO {

    private String nombreCalle;
    private Integer numeroCalle;
    private String piso;
    private String departamento;
    private String nombreEdificio;
}
