package petOps.com.petshop.model.dtos;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TutorDTO {

    private String nomeTutor;

    private String cpf;

    private String telefone;

    private String email;

    private LocalDate dataNascimento;

    private Set<EnderecoDTO> enderecos;

}
