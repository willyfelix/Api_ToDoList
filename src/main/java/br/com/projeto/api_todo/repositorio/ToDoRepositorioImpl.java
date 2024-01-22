// Corrigir nome da anotação para @Repository
package br.com.projeto.api_todo.repositorio;

import org.springframework.stereotype.Repository;
import br.com.projeto.api_todo.modelo.ToDo;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoRepositorioImpl implements ToDoRepositorio {
   
    private List<ToDo> todos = new ArrayList<>();
    private Long idCounter = 1L;

    @Override
    public List<ToDo> getAllTodos() {
        return todos;
    }

    @Override
    public ToDo getToDoById(Long id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ToDo createToDo(ToDo toDo) {
        toDo.setId(idCounter++);
        todos.add(toDo);
        return toDo;
    }

    @Override
    public ToDo updateToDo(Long id, ToDo updatedTodo) {
        for (ToDo todo : todos) {
            if (todo.getId().equals(id)) {
                todo.settitle(updatedTodo.gettitle());
                todo.setCompleted(updatedTodo.isCompleted());
                return todo;
            }
        }
        return null;
    }

    @Override
    public void deleteToDo(Long id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }
}
