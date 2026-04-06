package com.vidaplus.api.domain.consulta.validacoes.agendamento;

import com.vidaplus.api.domain.ValidacaoExeption;
import com.vidaplus.api.domain.consulta.ConsultaRepository;
import com.vidaplus.api.domain.consulta.DadosAgendamentoConsulta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

    private final ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoExeption("Paciente já possui uma consulta agendada nesse dia!");
        }
    }

}
