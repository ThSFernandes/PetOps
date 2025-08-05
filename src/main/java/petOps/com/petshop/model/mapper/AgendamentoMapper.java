package petOps.com.petshop.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import petOps.com.petshop.model.dtos.agendamentoDto.AgendamentoCreateDTO;
import petOps.com.petshop.model.dtos.agendamentoDto.AgendamentoDTO;
import petOps.com.petshop.model.entity.Agendamento;
@Mapper(componentModel = "spring",
        uses = {PetMapper.class, FuncionarioMapper.class, ServicoMapper.class})
public interface AgendamentoMapper {

    AgendamentoDTO toDto(Agendamento agendamento);

    @Mapping(target = "idAgendamento", ignore = true)
    @Mapping(target = "pet", ignore = true)
    @Mapping(target = "funcionarioVeterinario", ignore = true)
    @Mapping(target = "funcionarioGroomer", ignore = true)
    @Mapping(target = "servicosAdicionais", ignore = true)
    Agendamento toEntity(AgendamentoCreateDTO agendamentoCreateDTO);
}

