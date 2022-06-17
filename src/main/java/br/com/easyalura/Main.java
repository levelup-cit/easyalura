package br.com.easyalura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("easyalura");// persistence unit é uma config do JPA
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    CursoDao cursoDao = new CursoDao(entityManager);
    InstrutorDao instrutorDao = new InstrutorDao(entityManager);

    EntityTransaction transaction = entityManager.getTransaction();

    transaction.begin();

    try {

    Instrutor flavio = new Instrutor("Flavio Henrique de Souza Almeida", """
        Flávio é desenvolvedor e instrutor, focado no desenvolvimento com Angular e procurando conciliar o frontend com o backend. Palestrou em conferências como QCON e MobileConf. É autor do best-seller "Cangaceiro JavaScript". Além da sua graduação e MBA em TI, também é graduado em Psicologia, aplicando os aprendizados desta área no desenvolvimento de software e de aplicações web.
        """);
    instrutorDao.insere(flavio);

      Instrutor arthur = new Instrutor("Arthur Parahyba", "Arthur é desenvolvedor Java há mais de 15 anos e entusiastas de boas práticas de código e design de software.");
      instrutorDao.insere(arthur);


      Curso novoCursoAngular = new Curso("Angular parte 1: produtividade e organização com framework SPA",
        """
            Adquira os fundamentos, a base para decolar com o framework
            Aplique boas práticas desde o início
            Crie seus primeiros componentes e diretivas
            Aprenda a realizar comunicação entre componentes
            Acelere seu desenvolvimento com Bootstrap 4
            Domine a organização em módulos
            Integre com o backend NodeJS como exemplo
              """,
        "angular-fundamentos",
        16);
      novoCursoAngular.adicionaInstrutor(flavio);
      novoCursoAngular.adicionaInstrutor(arthur);

      cursoDao.insere(novoCursoAngular);


      Curso novoCursoSpringMVC = new Curso("Spring MVC: crie um web app com Thymeleaf e Bootstrap", """
          Conheça o padrão MVC com o Spring MVC
          Use o Spring Data para persistência
          Crie views melhores com Thymeleaf
          Valide os seus dados com o BeanValidation
          Resolva suas dependências com injeção de dependências
          Use Spring Security para criar um login
          Estilize o HTML com Bootstrap
          """, "spring-mvc-thymeleaf-bootstrap", 12);
      novoCursoSpringMVC.adicionaInstrutor(arthur);
      cursoDao.insere(novoCursoSpringMVC);

      transaction.commit(); //update acontece no commit da transaction
    } catch (Exception ex) {
      transaction.rollback();
      ex.printStackTrace();
    }

    entityManager.clear();

    cursoDao.todos().stream()
        .map(
            curso -> String.format("Curso: %s, instrutores: %s", curso.getTitulo(),
                curso.getInstrutores().stream().map(Instrutor::getNome).toList()))
        .forEach(System.out::println);

    entityManager.close();
    entityManagerFactory.close();
  }

}
