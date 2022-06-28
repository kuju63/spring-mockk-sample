package jp.ne.kuju63.todo.usecase

import jp.ne.kuju63.todo.entity.ToDoItem
import org.springframework.stereotype.Service

@Service
class ToDoSearcherImpl : ToDoSearcher {
    override fun getAllTodo(): MutableList<ToDoItem> {
        TODO("Not yet implemented")
    }
}