package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data //ANOTATION DO LOMBOK!! SERVE PARA ABSTRAIR OS GETTERS, SETTERS, EQUALS AND HASHCODE, PORTANT, NÃO É NECESSÁRIO INSERI-LOS NA CLASSE
@NoArgsConstructor //CONSTRUTOR VAZIO OIS O HIBERNATE PRECISA PARA NÃO DAR ERRO
@AllArgsConstructor //CONSTRUTOR COM TODOS OS ATRIBUTOS DA CLASSE
@Entity //INFORMAR AO SPRING QUE ESSA CLASSE É UMA ENTIDADE
@Table(name = "tb_alunos") //IFNORMAR QUE SERA UAM TABELA
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //ANOTATION DO HIBERNATE
  private Long id;

  private String nome;

  @Column(unique = true) //CAMPO ÚNICO, O CPF NÃO PODE SE REPETIR
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) //UM ALUNO PODE TER VÁRIA AVALIAÇÕES FÍSICAS
  @JsonIgnore
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
