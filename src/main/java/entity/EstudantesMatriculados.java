package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EstudantesMatriculados {
    LocalDate dataMatricula;
    List<Estudante> estudantes = new ArrayList<>();
    TurmaCurso turma;

    public EstudantesMatriculados(String matricula, LocalDate dataMatricula, List<Estudante> estudantes, TurmaCurso turma) {
        if(VerificaString(matricula)||VerificaData(dataMatricula)|| VerificaEstudantes(estudantes)||VerificaTurma(turma))
            throw new IllegalArgumentException("todos os campos devem ser preenchido");
        this.turma = turma;
        if(podeMatricular(dataMatricula))
            throw new IllegalArgumentException("Nao pode Matricular");
        this.dataMatricula = dataMatricula;
        for (Estudante e :estudantes) {
            if (podeMatricular(dataMatricula))
                throw new IllegalArgumentException("Acabou as Vagas Para Esse Curso "+ estudantes.indexOf(e) +" ate "+estudantes.size());
            e.setMatricula(e.getMatricula()+matricula+turma.getVaga());
            turma.setVagasDisponiveis(turma.getVagasDisponiveis()-1);
        }
        this.estudantes = estudantes;
        this.turma = turma;
    }
    public EstudantesMatriculados(String matricula, LocalDate dataMatricula, Estudante estudante, TurmaCurso turma) {
        if(VerificaString(matricula)||VerificaData(dataMatricula)|| VerificaEstudante(estudante)||VerificaTurma(turma))
            throw new IllegalArgumentException("Obrigatoriedade:todos os valores devem ser informados");
        this.turma = turma;
        if(podeMatricular(dataMatricula))
            throw new IllegalArgumentException("Nao pode Matricular");
        this.dataMatricula = dataMatricula;
        estudante.setMatricula(estudante.getMatricula()+matricula+turma.getVaga());

        this.estudantes.add(estudante);
        turma.setVagasDisponiveis(turma.getVagasDisponiveis()-1);
        this.turma = turma;
    }

    private boolean VerificaEstudante(Estudante estudante) {
        if(estudante==null)
            return true;
        return false;
    }

    private boolean VerificaTurma(TurmaCurso turma) {
        if(turma==null)
            return true;
        return false;
    }

    private boolean VerificaEstudantes(List<Estudante> estudantes) {
        if (estudantes == null || estudantes.size()==0)
            return true;
        return false;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public Boolean podeMatricular(LocalDate dataMatricula){
        if (turma.getVagasDisponiveis() != 0){
            if(dataMatricula.isAfter(turma.getInicioMatriculas())&&dataMatricula.isBefore(turma.getFimMatriculas()))
                return false;
        }
            return true;
    }
    private boolean VerificaData(LocalDate dataNascimento) {
        if (dataNascimento == null)
            return true;
        return false;
    }

    private boolean VerificaString(String string) {
        if(string==null||string.trim().isEmpty())
            return true;
        return false;
    }

}
