import entity.Curso;
import entity.TurmaCurso;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class TurmaCursoTest {
    public Curso Curso(){
        return new Curso("Medicina", "380Meses","Medicina por dinheiro");
    }
    @Test
    @DisplayName("Deveria Cadastra uma Turma")
    void DeveriaCadastrarUmaTurma() {
        LocalDate inicioAulas = LocalDate.parse("02-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimAulas = LocalDate.parse("16-12-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate inicioMatriculas = LocalDate.parse("30-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimMatriculas = LocalDate.parse("20-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Curso curso = Curso();
        assertDoesNotThrow(() -> {
            new TurmaCurso("108sul", 2, inicioAulas, fimAulas, inicioMatriculas, fimMatriculas,curso);
        });
    }

    @Test
    @DisplayName("Não Deveria Cadastrar uma Turma sem uma data de Inicio Aulas")
    void NaoDeveriaCadastrarumaTurmaSemUmaDataDeInicioAulas() {
        LocalDate fimAulas = LocalDate.parse("16-12-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate inicioMatriculas = LocalDate.parse("30-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimMatriculas = LocalDate.parse("20-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Curso curso = Curso();
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new TurmaCurso("108sul", 2, null, fimAulas, inicioMatriculas, fimMatriculas,curso);
        });
    }

    @Test
    @DisplayName("Não Deveria Cadastrar uma Turma sem uma data de Fim Aulas")
    void NaoDeveriaCadastrarumaTurmaSemUmaDataDeFimAulas() {
        LocalDate inicioAulas = LocalDate.parse("02-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate inicioMatriculas = LocalDate.parse("30-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimMatriculas = LocalDate.parse("20-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Curso curso = Curso();
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new TurmaCurso("108sul", 2, inicioAulas, null, inicioMatriculas, fimMatriculas,curso);
        });
    }

    @Test
    @DisplayName("Não Deveria Cadastrar uma Turma sem uma data de Inicio Matriculas")
    void NaoDeveriaCadastrarumaTurmaSemUmaDataDeInicioMatriculas() {
        LocalDate inicioAulas = LocalDate.parse("02-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimAulas = LocalDate.parse("16-12-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimMatriculas = LocalDate.parse("20-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Curso curso = Curso();
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new TurmaCurso("108sul", 2, inicioAulas, fimAulas,null, fimMatriculas,curso);
        });
    }

    @Test
    @DisplayName("Não Deveria Cadastrar uma Turma sem uma data de Fim Matriculas")
    void NaoDeveriaCadastrarumaTurmaSemUmaDataDeFimMatriculas() {
        LocalDate inicioAulas = LocalDate.parse("02-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimAulas = LocalDate.parse("16-12-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate inicioMatriculas = LocalDate.parse("30-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Curso curso = Curso();
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new TurmaCurso("108sul", 2, inicioAulas, fimAulas, inicioMatriculas, null,curso);
        });
    }

    @Test
    @DisplayName("Não Deveria Cadastrar uma Turma sem local")
    void DeveriaNaoCadastrarTurmaSemLocal() {
        LocalDate inicioAulas = LocalDate.parse("02-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimAulas = LocalDate.parse("16-12-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate inicioMatriculas = LocalDate.parse("30-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimMatriculas = LocalDate.parse("20-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Curso curso = Curso();
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new TurmaCurso(" ", 2, inicioAulas, fimAulas, inicioMatriculas, fimMatriculas,curso);
        });
    }
    @Test
    @DisplayName("Não Deveria Cadastrar uma Turma sem local")
    void DeveriaNaoCadastrarTurmaSemLocal2() {
        LocalDate inicioAulas = LocalDate.parse("02-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimAulas = LocalDate.parse("16-12-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate inicioMatriculas = LocalDate.parse("30-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimMatriculas = LocalDate.parse("20-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Curso curso = Curso();
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new TurmaCurso(null, 2, inicioAulas, fimAulas, inicioMatriculas, fimMatriculas,curso);
        });
    }
    @Test
    @DisplayName("Não Deveria Cadastrar uma Turma com datas eradas")
    void NaoDeveriaCadastrarumaTurmaComDatasErradas() {
        LocalDate inicioAulas = LocalDate.parse("16-12-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimAulas = LocalDate.parse("02-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate inicioMatriculas = LocalDate.parse("30-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimMatriculas = LocalDate.parse("20-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Curso curso = Curso();
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new TurmaCurso("108sul", 2, inicioAulas, fimAulas, inicioMatriculas, fimMatriculas,curso);
        });
    }
    @Test
    @DisplayName("Não Deveria Cadastrar uma Turma sem Curso")
    void NaoDeveriaCadastrarumaTurmaSemCurso() {
        LocalDate inicioAulas = LocalDate.parse("02-02-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimAulas = LocalDate.parse("16-12-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate inicioMatriculas = LocalDate.parse("30-12-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate fimMatriculas = LocalDate.parse("20-01-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Curso curso = Curso();
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new TurmaCurso("108sul", 2, inicioAulas, fimAulas, inicioMatriculas, fimMatriculas,null);
        });
    }

}
