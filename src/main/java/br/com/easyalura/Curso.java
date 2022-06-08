package br.com.easyalura;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cursos")
public class Curso {

  // tem que poder ser nulo (evitar tipos primitivos)
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;

  private String descricao;

  private String slug;

  @Column(name = "carga_horaria")
  private int cargaHoraria;

  @Column(name = "data_criacao")
  private LocalDate dataCriacao;

  @Column(name = "data_atualizacao")
  private LocalDate dataAtualizacao;

  @ManyToOne(fetch = FetchType.LAZY)
  private Instrutor instrutor;

  @Deprecated
  protected Curso() {
  }

  public Curso(String titulo, String descricao, String slug, int cargaHoraria, Instrutor instrutor) {
    this.titulo = titulo;
    this.descricao = descricao;
    this.slug = slug;
    this.cargaHoraria = cargaHoraria;
    this.instrutor = instrutor;
    this.dataCriacao = LocalDate.now();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public int getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(int cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  public LocalDate getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public LocalDate getDataAtualizacao() {
    return dataAtualizacao;
  }

  public void setDataAtualizacao(LocalDate dataAtualizacao) {
    this.dataAtualizacao = dataAtualizacao;
  }

  @Override
  public String toString() {
    return "Curso{" +
        "id=" + id +
        ", titulo='" + titulo + '\'' +
        ", descricao='" + descricao + '\'' +
        ", slug='" + slug + '\'' +
        ", cargaHoraria=" + cargaHoraria +
        ", dataCriacao=" + dataCriacao +
        ", dataAtualizacao=" + dataAtualizacao +
        ", instrutor=" + instrutor + // usa o instrutor!
        '}';
  }
}
