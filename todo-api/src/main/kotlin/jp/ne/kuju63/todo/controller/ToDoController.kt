package jp.ne.kuju63.todo.controller

import jp.ne.kuju63.todo.usecase.ToDoSearcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ToDoController @Autowired constructor(private  val useCase: ToDoSearcher) {

    @GetMapping("/")
    fun getToDoList(): MutableList<ToDoResponse> {
        return useCase.getAllTodo().stream().map { ToDoResponse(it.itemId, it.title, it.summary) }.toList()
    }
}
