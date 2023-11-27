import ToDoRowItem from "./ToDoRowItem";

const ToDoTable = ({ todos, deleteToDo }) => {
  return (
    <table className="table table-hover">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Description</th>
          <th scope="col">Assigned</th>
        </tr>
      </thead>
      <tbody>
        {todos.map(({ rowNumber, rowDescription, rowAssigned }) => (
          <ToDoRowItem
            key={rowNumber}
            rowNumber={rowNumber}
            rowAssigned={rowAssigned}
            rowDescription={rowDescription}
            deleteToDo={deleteToDo}
          />
        ))}
      </tbody>
    </table>
  );
};

export default ToDoTable;
