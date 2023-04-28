package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {
  //NOTBLANK É PARA CARACTERES E NOT NULL É PARA NUMEROS
  @NotBlank(message = "Preencha o campo corretamente.")
  @Size(min = 3, max = 50, message = "'${validatedValue' precisa estra entre {min} e {max} caracteres.")
  private String nome;

  @NotBlank(message = "Preencha o campo corretamente.")
  @CPF(message = "'$validatedValue' é inválido")
  private String cpf;

  @NotBlank(message = "Preencha o campo corretamente.")
  @Size(min = 3, max = 50, message = "'${validatedValue' precisa estra entre {min} e {max} caracteres.")
  private String bairro;

  //NOTBLANK É PARA CARACTERES E NOT NULL É PARA NUMEROS
  @NotNull(message = "Preencha o campo corretamente.")
  @Past(message = "Data '${validatedValue}' é inválida.") //DATA DE NASCIMENTO TEM QUE SER NO PASSADO
  private LocalDate dataDeNascimento;
}
