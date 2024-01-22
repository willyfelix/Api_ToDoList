package br.com.projeto.api_todo.repositorio;

import br.com.projeto.api_todo.modelo.ToDo;
import java.util.List;


public interface ToDoRepositorio {

    List<ToDo> getAllTodos();

    ToDo getTodoById(Long id);

    ToDo createTodo(ToDo todo);

    ToDo updateTodo(Long id, ToDo updatedTodo);

    void deleteTodo(Long id);
}
