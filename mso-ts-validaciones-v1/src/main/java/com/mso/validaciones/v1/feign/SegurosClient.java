package com.mso.validaciones.v1.feign;

import com.mso.validaciones.v1.dto.SeguroDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "segurosClient",
        url = "http://localhost:8080"//puerto del MS consultas
)
public interface SegurosClient {

    @GetMapping("/seguros/{idSeguro}")
    SeguroDto obtenerSeguroPorId(@PathVariable("idSeguro") Integer idSeguro);
}
