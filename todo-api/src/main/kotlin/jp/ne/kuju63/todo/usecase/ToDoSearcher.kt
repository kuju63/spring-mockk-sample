package jp.ne.kuju63.todo.usecase

import jp.ne.kuju63.todo.entity.ToDoItem

interface ToDoSearcher {

    fun getAllTodo(): MutableList<ToDoItem>
}