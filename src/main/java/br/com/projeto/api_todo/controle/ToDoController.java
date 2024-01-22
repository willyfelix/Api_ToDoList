package br.com.projeto.api_todo.controle;

import br.com.projeto.api_todo.modelo.ToDo;
import br.com.projeto.api_todo.repositorio.ToDoRepositorio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    private final ToDoRepositorio toDoRepositorio;

    public ToDoController(ToDoRepositorio toDoRepositorio) {
        this.toDoRepositorio = toDoRepositorio;
    }

    @GetMapping
    public List<ToDo> getAllTodos() {
        return toDoRepositorio.getAllTodos();
    }

    @GetMapping("/{id}")
    public ToDo getTodoById(@PathVariable Long id) {
        return toDoRepositorio.getTodoById(id);
    }

    @PostMapping
    public ToDo createToDo(@RequestBody ToDo toDo) {
        return toDoRepositorio.createToDo(toDo);
    }

    @PutMapping("/{id}")
    public ToDo updateToDo(@PathVariable Long id, @RequestBody ToDo updatedToDo) {
        ToDo todoToUpdate = toDoRepositorio.getTodoById(id);

        if (todoToUpdate != null) {
            todoToUpdate.settitle(updatedToDo.gettitle());
            todoToUpdate.setCompleted(updatedToDo.isCompleted());
            return toDoRepositorio.updateToDo(id, todoToUpdate);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id) {
        toDoRepositorio.deleteToDo(id);
    }
}

