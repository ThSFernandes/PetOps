package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.agendamentoDto.AgendamentoCreateDTO;
import petOps.com.petshop.model.dtos.agendamentoDto.AgendamentoDTO;
import petOps.com.petshop.model.entity.Agendamento;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper {
    AgendamentoDTO toDto(Agendamento agendamento);

    @Mapping(target = "idAgendamento", ignore = true)
    Agendamento toEntity(AgendamentoCreateDTO agendamentoCreateDTO);
}
