package entity;

import java.time.LocalDate;

public class TurmaCurso {
    private String local;
    private int vagas;
    private int vagasDisponiveis;
    private LocalDate inicioAulas;
    private LocalDate fimAulas;
    private LocalDate inicioMatriculas;
    private LocalDate fimMatriculas;
    private Curso curso;

    public TurmaCurso(String local, int vagas, LocalDate inicioAulas, LocalDate fimAulas, LocalDate inicioMatriculas, LocalDate fimMatriculas, Curso curso) {
        if (VerificaString(local) || VerificaVagas(vagas) || VerificaData(inicioAulas) || VerificaData(fimAulas) || VerificaData(inicioMatriculas) || VerificaData(fimMatriculas)||VerificaCurso(curso))
            throw new IllegalArgumentException("todos os campos devem ser preenchido");
        if (VerificaDatas(inicioMatriculas, fimMatriculas, inicioAulas, fimAulas))
            throw new IllegalArgumentException("Datas incoretas");
        this.local = local;
        this.vagas = vagas;
        this.vagasDisponiveis = vagas;
        this.inicioAulas = inicioAulas;
        this.fimAulas = fimAulas;
        this.inicioMatriculas = inicioMatriculas;
        this.fimMatriculas = fimMatriculas;
        this.curso=curso;
    }

    private boolean VerificaCurso(Curso curso) {
        if (curso == null)
            return true;
        return false;
    }

    private boolean VerificaDatas(LocalDate inicioMatriculas, LocalDate fimMatriculas, LocalDate inicioAulas, LocalDate fimAulas) {
        if (inicioMatriculas.isBefore(fimMatriculas) && fimMatriculas.isBefore(inicioAulas) && inicioAulas.isBefore(fimAulas))
            return false;
        return true;
    }

    private boolean VerificaData(LocalDate data) {
        if (data == null)
            return true;
        return false;
    }

    private boolean VerificaString(String string) {
        if (string == null || string.trim().isEmpty())
            return true;
        return false;
    }

    public Boolean VerificaVagas(int vagas) {
        if (vagas == 0)
            return true;
        return false;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public LocalDate getInicioAulas() {
        return inicioAulas;
    }

    public void setInicioAulas(LocalDate inicioAulas) {
        this.inicioAulas = inicioAulas;
    }

    public LocalDate getFimAulas() {
        return fimAulas;
    }

    public void setFimAulas(LocalDate fimAulas) {
        this.fimAulas = fimAulas;
    }

    public LocalDate getInicioMatriculas() {
        return inicioMatriculas;
    }

    public void setInicioMatriculas(LocalDate inicioMatriculas) {
        this.inicioMatriculas = inicioMatriculas;
    }

    public LocalDate getFimMatriculas() {
        return fimMatriculas;
    }

    public void setFimMatriculas(LocalDate fimMatriculas) {
        this.fimMatriculas = fimMatriculas;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getVaga() {
        return vagas - vagasDisponiveis + 1;
    }
}
