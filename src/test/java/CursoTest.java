import entity.Curso;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CursoTest {
    @Test
    @DisplayName("Cadastra um Curso")
    void DeveriaCadastrarCurso(){
        assertDoesNotThrow(()->{
            new Curso("Medicina", "380Meses","Medicina por dinheiro");
        });
    }
    @Test
    @DisplayName("Não Deveria Cadastrar um curso sem nome")
    void NaoDeveriaCadastrarUmCursoSemNome(){
        assertThrowsExactly(IllegalArgumentException.class,()->{
            new Curso(null, "380Meses","Medicina por dinheiro");
        });
    }
    @Test
    @DisplayName("Não Deveria Cadastrar um curso sem Carga Horaria")
    void NaoDeveriaCadastrarUmCursoSemCargaHoraria(){
        assertThrowsExactly(IllegalArgumentException.class,()->{
            new Curso("Medicina", " ","Medicina por dinheiro");
        });
    }
    @Test
    @DisplayName("Não Deveria Cadastrar um curso sem Carga Horaria")
    void NaoDeveriaCadastrarUmCursoSemCargaHoraria2(){
        assertThrowsExactly(IllegalArgumentException.class,()->{
            new Curso("Medicina", null,"Medicina por dinheiro");
        });
    }
    @Test
    @DisplayName("Não Deveria Cadastrar um curso sem Descricao")
    void NaoDeveriaCadastrarUmCursoSemDescricao(){
        assertThrowsExactly(IllegalArgumentException.class,()->{
            new Curso("Medicina", "380Meses"," ");
        });
    }@Test
    @DisplayName("Não Deveria Cadastrar um curso sem Descricao")
    void NaoDeveriaCadastrarUmCursoSemDescricao2(){
        assertThrowsExactly(IllegalArgumentException.class,()->{
            new Curso("Medicina", "380Meses",null);
        });
    }
}
