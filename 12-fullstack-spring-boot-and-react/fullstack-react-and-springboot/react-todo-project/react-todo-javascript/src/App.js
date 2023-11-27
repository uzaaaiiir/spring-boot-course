import "./App.css";
import ToDoTable from "./components/ToDoTable";
import NewToDoForm from "./components/NewToDoForm";
import { useState } from "react";

function App() {
  const [showAddToDoForm, setShowAddToDoForm] = useState(false);

  const [todos, setTodos] = useState([
    { rowNumber: 1, rowDescription: "Feed puppy", rowAssigned: "User One" },
    { rowNumber: 2, rowDescription: "Water plants", rowAssigned: "User Two" },
    { rowNumber: 3, rowDescription: "Make Dinner", rowAssigned: "User One" },
    {
      rowNumber: 4,
      rowDescription: "Charge phone battery",
      rowAssigned: "User One",
    },
  ]);

  const addToDo = (description, assigned) => {
    let rowNumber = 0;

    if (todos.length > 0) {
      rowNumber = todos[todos.length - 1].rowNumber + 1;
    } else {
      rowNumber = 1;
    }

    if (todos.length > 0) {
      const newTodo = {
        rowNumber: rowNumber,
        rowDescription: description,
        rowAssigned: assigned,
      };
      setTodos((todos) => [...todos, newTodo]);
      console.log(todos);
    }
  };

  const deleteToDo = (rowNumber) => {
    let filtered = todos.filter((value) => value.rowNumber !== rowNumber);
    setTodos(filtered);
  };

  return (
    <div className="mt-5 container">
      <div className="card">
        <div className="card-header">Your Todo's</div>
        <div className="card-body">
          <ToDoTable todos={todos} deleteToDo={deleteToDo} />
          <button
            className="btn btn-primary"
            onClick={() => setShowAddToDoForm(!showAddToDoForm)}
          >
            {showAddToDoForm ? "Close New ToDo" : "New ToDo"}
          </button>
          {showAddToDoForm && <NewToDoForm addToDo={addToDo} />}
        </div>
      </div>
    </div>
  );
}

export default App;
