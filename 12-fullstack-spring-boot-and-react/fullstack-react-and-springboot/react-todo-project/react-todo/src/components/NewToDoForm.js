import { useState } from "react";

const NewToDoForm = ({ addToDo }) => {
  const [description, setDescription] = useState("");
  const [assigned, setAssigned] = useState("");

  const submitToDo = () => {
    if (description !== "" && assigned !== "") {
      addToDo(description, assigned);

      setDescription("");
      setAssigned("");
    }
  };

  return (
    <div className="mt-5">
      <form>
        <div className="mb-3">
          <label htmlFor="" className="form-label">
            Assigned
          </label>
          <input
            type="text"
            className="form-control"
            required
            onChange={(e) => setAssigned(e.target.value)}
            value={assigned}
          ></input>
        </div>
        <div className="mb-3">
          <label className="form-label">Description</label>
          <textarea
            rows={3}
            className="form-control"
            required
            onChange={(e) => setDescription(e.target.value)}
            value={description}
          ></textarea>
        </div>
        <button
          type="button"
          className="btn btn-primary mt-3"
          onClick={submitToDo}
        >
          Add ToDo
        </button>
      </form>
    </div>
  );
};

export default NewToDoForm;
