package br.com.projeto.api_todo.repositorio;

import br.com.projeto.api_todo.modelo.ToDo;
import java.util.List;


public interface ToDoRepositorio {

    List<ToDo> getAllTodos();

    ToDo getToDoById(Long id);

    ToDo createToDo(ToDo todo);

    ToDo updateToDo(Long id, ToDo updatedTodo);

    void deleteToDo(Long id);
}
