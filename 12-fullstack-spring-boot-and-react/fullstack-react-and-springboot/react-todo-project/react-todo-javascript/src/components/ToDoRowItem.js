const ToDoRowItem = ({
  rowNumber,
  rowAssigned,
  rowDescription,
  deleteToDo,
}) => {
  return (
    <tr onClick={() => deleteToDo(rowNumber)}>
      <th scope="row">{rowNumber}</th>
      <td>{rowDescription}</td>
      <td>{rowAssigned}</td>
    </tr>
  );
};

export default ToDoRowItem;
