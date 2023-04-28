package me.dio.academia.digital.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
//ANOTATION DO LOMBOK!! SERVE PARA ABSTRAIR OS GETTERS, SETTERS, EQUALS AND HASHCODE, PORTANT, NÃO É NECESSÁRIO INSERI-LOS NA CLASSE
@NoArgsConstructor //CONSTRUTOR VAZIO OIS O HIBERNATE PRECISA PARA NÃO DAR ERRO
@AllArgsConstructor //CONSTRUTOR COM TODOS OS ATRIBUTOS DA CLASSE
@Entity //INFORMAR AO SPRING QUE ESSA CLASSE É UMA ENTIDADE
@Table(name = "tb_matriculas") //IFNORMAR QUE SERA UAM TABELA
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //ANOTATION DO HIBERNATE
  private Long id;

  @OneToOne(cascade = CascadeType.ALL) //UMA MATRICULA PARA UM ALUNO
  @JoinColumn(name = "aluno_id") //NOME DA COLUNA Q VAI CONTER AS FOREIGN KEY
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
