package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.AgendamentoCreateDTO;
import petOps.com.petshop.model.dtos.AgendamentoDTO;
import petOps.com.petshop.model.entity.Agendamento;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper {
    AgendamentoDTO toDto(Agendamento agendamento);

    @Mapping(target = "id_agendamento", ignore = true)
    Agendamento toEnity(AgendamentoCreateDTO agendamentoCreateDTO);
}
