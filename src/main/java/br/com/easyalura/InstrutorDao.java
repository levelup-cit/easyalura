package br.com.easyalura;

import javax.persistence.EntityManager;
import java.util.List;

public class InstrutorDao {

  private final EntityManager entityManager;

  public InstrutorDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void insere(Instrutor instrutor) {
    entityManager.persist(instrutor);
  }

  public Instrutor buscaPorId(Long id) {
    return entityManager.find(Instrutor.class, id);
  }

  public List<Instrutor> todos() {
    String jpql = "select i from Instrutor i";
    return entityManager.createQuery(jpql, Instrutor.class).getResultList();
  }

}
