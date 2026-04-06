package com.vidaplus.api.domain.consulta.validacoes.cancelamento;

import com.vidaplus.api.domain.ValidacaoExeption;
import com.vidaplus.api.domain.consulta.ConsultaRepository;
import com.vidaplus.api.domain.consulta.DadosCancelamentoConsulta;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
@RequiredArgsConstructor
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeConsulta {

    private final ConsultaRepository consultaRepository;

    @Override
    public void validar(DadosCancelamentoConsulta dados) {

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoExeption("Consulta somente pode ser cancelada com antecedência mínima de 24h!");

        }

    }

}
