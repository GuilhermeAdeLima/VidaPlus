package com.vidaplus.api.domain.paciente;

import com.vidaplus.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(@NotNull
                                       Long id,
                                       String nome,
                                       String telefone,
                                       DadosEndereco endereco) {
}
