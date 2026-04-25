import React, { useState } from "react";

const USER_ID = "807ca9a3-3483-49c9-bb8b-57c7cd6ac494";

export default function TaskForm({ onCreate, projects }) {
  const [titulo, setTitulo] = useState("");
  const [descripcion, setDescripcion] = useState("");
  const [fecha, setFecha] = useState("");
  const [prioridad, setPrioridad] = useState("MEDIA");
  const [proyectoId, setProyectoId] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    onCreate({
      titulo,
      descripcion,
      prioridad,
      fechaLimite: fecha,
      usuarioId: USER_ID,
      proyectoId: proyectoId || null,
    });

    setTitulo("");
    setDescripcion("");
    setFecha("");
    setProyectoId("");
  };

  return (
    <form className="form" onSubmit={handleSubmit}>
      <input
        placeholder="Título"
        value={titulo}
        onChange={(e) => setTitulo(e.target.value)}
      />

      <input
        placeholder="Descripción"
        value={descripcion}
        onChange={(e) => setDescripcion(e.target.value)}
      />

      <input
        type="date"
        value={fecha}
        onChange={(e) => setFecha(e.target.value)}
      />

      <select value={prioridad} onChange={(e) => setPrioridad(e.target.value)}>
        <option value="BAJA">Baja</option>
        <option value="MEDIA">Media</option>
        <option value="ALTA">Alta</option>
      </select>

      <select
        value={proyectoId}
        onChange={(e) => setProyectoId(e.target.value)}
      >
        <option value="">Sin proyecto</option>
        {projects.map((p) => (
          <option key={p.id} value={p.id}>
            {p.nombre}
          </option>
        ))}
      </select>

      <button type="submit">Crear tarea</button>
    </form>
  );
}