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

    private String nome_tutor;

    private String cpf;

    private String telefone;

    private String email;

    private LocalDate data_nascimento;

    private Set<EnderecoDTO> enderecos;

}
