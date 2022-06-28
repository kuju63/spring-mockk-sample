package jp.ne.kuju63.todo.controller

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import jp.ne.kuju63.todo.entity.ToDoItem
import jp.ne.kuju63.todo.usecase.ToDoSearcher
import org.hamcrest.collection.IsEmptyIterable
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest

@WebMvcTest
class ToDoControllerTest {

    @MockK
    lateinit var useCase: ToDoSearcher

    @BeforeEach
    fun setup() = MockKAnnotations.init(this, relaxUnitFun = true)

    @Test
    fun `should return empty list when useCase does not find todo`() {
        every { useCase.getAllTodo() } returns emptyList<ToDoItem>().toMutableList()


        val controller = ToDoController(useCase)

        assertTrue(IsEmptyIterable.emptyIterable<ToDoResponse>().matches(controller.getToDoList()))
    }

}