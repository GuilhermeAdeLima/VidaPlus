package com.vidaplus.api.domain.consulta.validacoes.agendamento;

import com.vidaplus.api.domain.ValidacaoExeption;
import com.vidaplus.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferancaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferancaEmMinutos < 30) {
            throw new ValidacaoExeption("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }

    }

}
