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

//    Instrutor flavio = new Instrutor("Flavio Henrique de Souza Almeida", """
//        Flávio é desenvolvedor e instrutor, focado no desenvolvimento com Angular e procurando conciliar o frontend com o backend. Palestrou em conferências como QCON e MobileConf. É autor do best-seller "Cangaceiro JavaScript". Além da sua graduação e MBA em TI, também é graduado em Psicologia, aplicando os aprendizados desta área no desenvolvimento de software e de aplicações web.
//        """);
//
//    instrutorDao.insere(flavio);
//
//
//    Curso novoCursoAngular = new Curso("Angular parte 1: produtividade e organização com framework SPA",
//        """
//            Adquira os fundamentos, a base para decolar com o framework
//            Aplique boas práticas desde o início
//            Crie seus primeiros componentes e diretivas
//            Aprenda a realizar comunicação entre componentes
//            Acelere seu desenvolvimento com Bootstrap 4
//            Domine a organização em módulos
//            Integre com o backend NodeJS como exemplo
//              """,
//        "angular-fundamentos",
//        16, flavio);
//
//      cursoDao.insere(novoCursoAngular);

//      Instrutor arthur = new Instrutor("Arthur Parahyba", "Arthur é desenvolvedor Java há mais de 15 anos e entusiastas de boas práticas de código e design de software.");
//      instrutorDao.insere(arthur);
//
//      Curso novoCursoSpringMVC = new Curso("Spring MVC: crie um web app com Thymeleaf e Bootstrap", """
//          Conheça o padrão MVC com o Spring MVC
//          Use o Spring Data para persistência
//          Crie views melhores com Thymeleaf
//          Valide os seus dados com o BeanValidation
//          Resolva suas dependências com injeção de dependências
//          Use Spring Security para criar um login
//          Estilize o HTML com Bootstrap
//          """, "spring-mvc-thymeleaf-bootstrap", 12, arthur);
//      cursoDao.insere(novoCursoSpringMVC);

      Curso cursoDoArthur = cursoDao.buscaPorId(2L);
      cursoDoArthur.setTitulo("Springão da MASSA!!! É bom demais da conta!");
      // o EntityManager fica olhando o objeto MANAGED e, se você alterar algo E tiver numa transação
      //    o EntityManager vai fazer um update!

      transaction.commit(); //update acontece no commit da transaction
    } catch (Exception ex) {
      transaction.rollback();
      ex.printStackTrace();
    }



//    cursoDao.todos()
//        .stream()
//        //.map(Curso::getTitulo)
//        .forEach(System.out::println); // o toString do Curso usa o instrutor!

    entityManager.close();
    entityManagerFactory.close();
  }

}
