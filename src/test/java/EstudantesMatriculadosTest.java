
import entity.Celular;
import entity.Curso;
import entity.Estudante;
import entity.EstudantesMatriculados;
import entity.TurmaCurso;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class EstudantesMatriculadosTest {
    public Curso Curso(){
        return new Curso("Medicina", "380Meses","Medicina por dinheiro");
    }
    public Estudante Estudante(){//criando estudante
        LocalDate data = LocalDate.parse("20-02-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Celular c = new Celular("63985122699");
        List<Celular> celular = new ArrayList<>();
        celular.add(c);
        return new Estudante("Erick", data, "1006 sul", "erick@gmail.com", celular);
    }

    public TurmaCurso Turma(){//criando turma
        LocalDate inicioAulas = LocalDate.parse("02-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimAulas = LocalDate.parse("16-12-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate inicioMatriculas = LocalDate.parse("30-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimMatriculas = LocalDate.parse("20-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Curso curso =Curso();
        return new TurmaCurso("108sul", 2, inicioAulas, fimAulas,inicioMatriculas,fimMatriculas,curso);
    }
    @Test
    @DisplayName("Deveria Matricular um Estudante")
    void DeveriaMatricularUmEstudanteNaTurma(){
        TurmaCurso turma = Turma();
        Estudante estudante = Estudante();
        LocalDate dataMatricula = LocalDate.parse("01-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        assertDoesNotThrow(()->{
            new EstudantesMatriculados("01",dataMatricula,estudante,turma);
        });
    }
    @Test
    @DisplayName("Deveria Matricular dois Estudantes")
    void DeveriaCadastrarDoisEstudantes(){
        TurmaCurso turma = Turma();
        List<Estudante> list = new ArrayList<>();
        list.add(Estudante());
        list.add(Estudante());
        LocalDate dataMatricula = LocalDate.parse("31-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        assertDoesNotThrow(()->{
            new EstudantesMatriculados("01",dataMatricula,list,turma);
        });
    }
    @Test
    @DisplayName("Não Deveria Matricular um Estudante sem Data Matricula")
    void NaoDeveriaMatricularUmEstudanteNaTurmaSemDataMatricula(){
        TurmaCurso turma = Turma();
        Estudante estudante = Estudante();
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new EstudantesMatriculados("01",null,estudante,turma);
        });
    }

    @Test
    @DisplayName("Não Deveria Matricular um Estudante sem Matricula")
    void NaoDeveriaMatricularUmEstudanteNaTurmaSemMatricula(){
        TurmaCurso turma = Turma();
        Estudante estudante = Estudante();
        LocalDate dataMatricula = LocalDate.parse("31-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new EstudantesMatriculados(" ",dataMatricula,estudante,turma);
        });
    }@Test
    @DisplayName("Não Deveria Matricular um Estudante sem vaga")
    void NaoDeveriaMatricularUmEstudanteNaTurmaSemVaga(){
        TurmaCurso turma = Turma();
        List<Estudante> list = new ArrayList<>();
        list.add(Estudante());
        list.add(Estudante());
        list.add(Estudante());
        LocalDate dataMatricula = LocalDate.parse("31-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new EstudantesMatriculados("01",dataMatricula,list,turma);
        });
    }

}
