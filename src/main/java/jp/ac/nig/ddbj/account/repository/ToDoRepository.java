package jp.ac.nig.ddbj.account.repository;


import jp.ac.nig.ddbj.account.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo,String> {

}
