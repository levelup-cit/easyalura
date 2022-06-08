package br.com.easyalura;

import javax.persistence.EntityManager;
import java.util.List;

public class CursoDao {

  private final EntityManager entityManager;

  public CursoDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void insere(Curso curso) {
    entityManager.persist(curso);
  }

  public Curso buscaPorId(Long id) {
    return entityManager.find(Curso.class, id);
  }

  public List<Curso> todos() {
    String jpql = "select c from Curso c";
    return entityManager.createQuery(jpql, Curso.class).getResultList();
  }

}
