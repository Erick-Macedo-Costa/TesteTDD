package entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

public class Estudante {private String nome;
    private String matricula;
    private LocalDate dataNascimento;
    private String endereco;
    private String emailInstitucional;
    private List<Celular> celular;

    public Estudante(String nome, LocalDate dataNascimento, String endereco, String emailInstitucional, List<Celular> celulars) {
        if (VerificaString(nome) || VerificaString(endereco) || VerificaString(emailInstitucional) || VerificaData(dataNascimento) || VerificaCelular(celulars)||VerificaIdade(dataNascimento))
            throw new IllegalArgumentException("todos os campos devem ser preenchido");
        this.nome = nome;
        this.matricula = GeraMatricula();
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.emailInstitucional = emailInstitucional;
        this.celular = celulars;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmailInstitucional() {
        return emailInstitucional;
    }

    public void setEmailInstitucional(String emailInstitucional) {
        this.emailInstitucional = emailInstitucional;
    }

    public List<Celular> getCelular() {
        return celular;
    }

    public void setCelular(List<Celular> celular) {
        this.celular = celular;
    }

    private String GeraMatricula() {
        int ano = LocalDate.now().getYear();
        String matricula = ano + "";
        return matricula;
    }

    private boolean VerificaIdade(LocalDate dataNascimento) {
        int ano = dataNascimento.getYear();
        int anoatual = LocalDate.now().getYear();
        ano = anoatual - ano;
        if(ano<15)
            return true;
        return false;
    }

    private boolean VerificaCelular(List<Celular> celulars) {
        if (celulars == null || celulars.size()==0)
            return true;
        return false;
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

    public String toString(){
        return "Nome: "+nome+"  matricula: "+matricula;
    }

}
