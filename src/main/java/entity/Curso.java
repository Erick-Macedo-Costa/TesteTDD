package entity;

public class Curso {
    private String nome;
    private String cargaHoraria;
    private String Descricao;

    public Curso(String nome, String cargaHoraria, String descricao) {
        if (VerificaString(nome) || VerificaString(cargaHoraria) || VerificaString(descricao))
            throw new IllegalArgumentException("todos os campos devem ser preenchido");
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        Descricao = descricao;
    }

    private boolean VerificaString(String string) {
        if(string==null||string.trim().isEmpty())
            return true;
        return false;
    }
}
