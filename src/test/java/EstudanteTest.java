import entity.Celular;
import entity.Estudante;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class EstudanteTest {
    @Test
    @DisplayName("Deveeria Cadastra um estudante")
    void DeveriaCadastrarUmEstudante() {
        LocalDate data = LocalDate.parse("20-02-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Celular c = new Celular("63985122699");
        List<Celular> celular = new ArrayList<>();
        celular.add(c);
        assertDoesNotThrow(() -> {
            new Estudante("Erick", data, "1006 sul", "erick@gmail.com", celular);
        });
    }

    @Test
    @DisplayName("Não Cadastra um estudante com Nome vazio")
    void NaoDeveriaCadastrarUmEstudanteSemNome() {
        LocalDate data = LocalDate.parse("20-02-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Celular c = new Celular("63985122699");
        List<Celular> celular = new ArrayList<>();
        celular.add(c);
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante(" ", data, "1006 sul", "erick@gmail.com", celular);
        });
    }

    @Test
    @DisplayName("Não Cadastra um estudante com Nome nulo")
    void NaoDeveriaCadastrarUmEstudanteSemNome2() {
        LocalDate data = LocalDate.parse("20-02-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Celular c = new Celular("63985122699");
        List<Celular> celular = new ArrayList<>();
        celular.add(c);
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante(null, data, "1006 sul", "erick@gmail.com", celular);
        });
    }

    @Test
    @DisplayName("Não Cadastra um estudante Sem Data De Aniversario")
    void NaoDeveriaCadastrarUmEstudanteSemData() {
        Celular c = new Celular("63985122699");
        List<Celular> celular = new ArrayList<>();
        celular.add(c);
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante("Erick", null, "1006 sul", "erick@gmail.com", celular);
        });
    }

    @Test
    @DisplayName("Nao deveria cadastrar Estudantes Sem Endereço")
    void NaoDeveriaCadastrarEstudanteSemEndereco() {
        LocalDate data = LocalDate.parse("20-02-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Celular c = new Celular("63985122699");
        List<Celular> celular = new ArrayList<>();
        celular.add(c);
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante("Erick", data, null, "erick@gmail.com", celular);
        });

    }

    @Test
    @DisplayName("Nao deveria cadastrar Estudantes Sem Email")
    void NaoDeveriaCadastrarEstudanteSemEmail() {
        LocalDate data = LocalDate.parse("20-02-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Celular c = new Celular("63985122699");
        List<Celular> celular = new ArrayList<>();
        celular.add(c);
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante("Erick", data, "1006 sul", null, celular);
        });

    }

    @Test
    @DisplayName("Nao deveria cadastrar Estudantes Sem a o menos um Celular")
    void NaoDeveriaCadastrarEstudanteSemCelular() {
        LocalDate data = LocalDate.parse("20-02-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        List<Celular> celular = new ArrayList<>();
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante("Erick", data, "1006 sul", "erick@gmail.com", celular);
        });

    }

    @Test
    @DisplayName("Nao deveria cadastrar Estudantes Sem a o menos um Celular")
    void NaoDeveriaCadastrarEstudanteSemCelular2() {
        LocalDate data = LocalDate.parse("20-02-2002", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Celular c = new Celular("63985122699");
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante("Erick", data, "1006 sul", "erick@gmail.com", null);
        });

    }

    @Test
    @DisplayName("Não Cadastra um estudante com menos de 15 anos")
    void NaoDeveriaCadastarUmEstudanteMenoQue15() {
        LocalDate data = LocalDate.parse("20-02-2018", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Celular c = new Celular("63985122699");
        List<Celular> celular = new ArrayList<>();
        celular.add(c);
        assertThrowsExactly(java.lang.IllegalArgumentException.class, () -> {
            new Estudante("Erick", data, "1006 sul", "erick@gmail.com", celular);
        });
    }

}
