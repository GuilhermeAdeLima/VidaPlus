package com.vidaplus.api.domain.consulta;

import com.vidaplus.api.domain.consulta.validacoes.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(

        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo) {

}
