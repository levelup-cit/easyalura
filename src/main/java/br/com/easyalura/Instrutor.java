package br.com.easyalura;

import javax.persistence.*;

@Entity
@Table(name = "instrutores")
public class Instrutor {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private String descricao;

  @Column(name = "linkedin_url")
  private String linkedinUrl;

  @Deprecated
  public Instrutor() {
  }

  public Instrutor(String nome, String descricao) {
    this.nome = nome;
    this.descricao = descricao;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getLinkedinUrl() {
    return linkedinUrl;
  }

  public void setLinkedinUrl(String linkedinUrl) {
    this.linkedinUrl = linkedinUrl;
  }

  @Override
  public String toString() {
    return "Instrutor{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", descricao='" + descricao + '\'' +
        ", linkedinUrl='" + linkedinUrl + '\'' +
        '}';
  }
}
