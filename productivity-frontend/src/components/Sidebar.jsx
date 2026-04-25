import React from "react";

export default function Sidebar({ projects, onSelect, selected }) {
  return (
    <div className="sidebar">
      <h3>Proyectos</h3>

      <div
        className={`sidebar-item ${selected === null ? "active" : ""}`}
        onClick={() => onSelect(null)}
      >
        Todas
      </div>

      {projects.map((p) => (
        <div
          key={p.id}
          className={`sidebar-item ${selected === p.id ? "active" : ""}`}
          onClick={() => onSelect(p.id)}
        >
          {p.nombre}
        </div>
      ))}
    </div>
  );
}