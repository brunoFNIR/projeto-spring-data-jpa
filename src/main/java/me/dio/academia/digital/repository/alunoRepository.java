package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                    //tipo da classe, tipo do Id
public interface alunoRepository extends JpaRepository<Aluno, Long> {
    //so de herdar dee jparepository já tem vários métodos
}
