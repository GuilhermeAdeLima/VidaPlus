package com.vidaplus.api.domain.consulta.validacoes.agendamento;

import com.vidaplus.api.domain.ValidacaoExeption;
import com.vidaplus.api.domain.consulta.DadosAgendamentoConsulta;
import com.vidaplus.api.domain.paciente.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    private final PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados) {

        if (dados.idPaciente() == null) {
            return;
        }

        var pacienteEstaAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoExeption("Consulta não pode ser agendada com paciente inativo!");
        }

    }
}
