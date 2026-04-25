import React from "react";

export default function TaskCard({ task, onComplete, onCancel, onDelete }) {
  return (
    <div className="card">
      <h3>{task.titulo}</h3>
      <p>{task.descripcion}</p>

      <div className="meta">
        <span className={`estado ${task.estado}`}>{task.estado}</span>
        <span>{task.prioridad}</span>
      </div>

      <div className="buttons">
        <button className="btn-complete" onClick={() => onComplete(task.id)}>
          ✔
        </button>
        <button className="btn-cancel" onClick={() => onCancel(task.id)}>
          ✖
        </button>
        <button className="btn-delete" onClick={() => onDelete(task.id)}>
          🗑
        </button>
      </div>
    </div>
  );
}