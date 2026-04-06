package com.vidaplus.api.domain.consulta.validacoes.agendamento;

import com.vidaplus.api.domain.ValidacaoExeption;
import com.vidaplus.api.domain.consulta.DadosAgendamentoConsulta;
import com.vidaplus.api.domain.medico.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {


    private final MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {

        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoExeption("Consulta não pode ser agendada com médico inativo!");
        }

    }

}
