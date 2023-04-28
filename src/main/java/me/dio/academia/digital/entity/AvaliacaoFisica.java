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
@Table(name = "tb_avaliacoes") //IFNORMAR QUE SERA UAM TABELA
public class AvaliacaoFisica {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //ANOTATION DO HIBERNATE
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)//CASCADE = TODA ALTERAÇÃO FEITA EM AVALICAO FISICA, SERA FEITA TBM EM ALUNO //VARIAS AVALIAÇÕES PARA UM ALUNO
  @JoinColumn(name = "aluno_id") //COLUNA DA FOREIGN KEY VAI TA DENTRO DE AVALIAÇOES FISICAS
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual") //PARA MUDAR O NOME DA COLUNA
  private double peso;

  @Column(name = "altura_atual")
  private double altura;

}
