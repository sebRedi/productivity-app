import React, { useEffect, useState } from "react";
import {
  getTasks,
  createTask,
  completeTask,
  cancelTask,
  deleteTask,
  getProjects,
  createProject,
} from "../api/api";
import TaskCard from "../components/TaskCard";
import TaskForm from "../components/TaskForm";
import Sidebar from "../components/Sidebar";
import { Pie } from "react-chartjs-2";
import { Chart, ArcElement, Tooltip, Legend } from "chart.js";

Chart.register(ArcElement, Tooltip, Legend);

export default function Dashboard() {
  const [tasks, setTasks] = useState([]);
  const [projects, setProjects] = useState([]);
  const [filter, setFilter] = useState("ALL");
  const [selectedProject, setSelectedProject] = useState(null);
  const [newProject, setNewProject] = useState("");

  const loadTasks = async () => {
    const res = await getTasks();
    setTasks(res.data);
  };

  const loadProjects = async () => {
    const res = await getProjects();
    setProjects(res.data);
  };

  useEffect(() => {
    loadTasks();
    loadProjects();
  }, []);

  const handleCreate = async (data) => {
    await createTask(data);
    loadTasks();
  };

  const handleDelete = async (id) => {
    if (!confirm("Eliminar tarea?")) return;
    await deleteTask(id);
    loadTasks();
  };

  const handleComplete = async (id) => {
    await completeTask(id);
    loadTasks();
  };

  const handleCancel = async (id) => {
    await cancelTask(id);
    loadTasks();
  };

  const handleCreateProject = async () => {
    await createProject({
      nombre: newProject,
      descripcion: "",
      usuarioId: "807ca9a3-3483-49c9-bb8b-57c7cd6ac494",
    });
    setNewProject("");
    loadProjects();
  };

  const filteredTasks = tasks.filter((t) => {
    if (selectedProject && t.proyectoId !== selectedProject) return false;
    if (filter === "PENDIENTE") return t.estado === "PENDIENTE";
    if (filter === "COMPLETADA") return t.estado === "COMPLETADA";
    return true;
  });

  const data = {
    labels: ["Pendientes", "Completadas"],
    datasets: [
      {
        data: [
          tasks.filter((t) => t.estado === "PENDIENTE").length,
          tasks.filter((t) => t.estado === "COMPLETADA").length,
        ],
        backgroundColor: ["#f59e0b", "#22c55e"],
      },
    ],
  };

  return (
    <div className="layout">
      <Sidebar
        projects={projects}
        selected={selectedProject}
        onSelect={setSelectedProject}
      />

      <div className="main">
        <h1>Dashboard</h1>

        <div className="top-bar">
          <input
            placeholder="Nuevo proyecto"
            value={newProject}
            onChange={(e) => setNewProject(e.target.value)}
          />
          <button onClick={handleCreateProject}>Crear</button>

          <div className="filters">
            <button onClick={() => setFilter("ALL")}>Todas</button>
            <button onClick={() => setFilter("PENDIENTE")}>
              Pendientes
            </button>
            <button onClick={() => setFilter("COMPLETADA")}>
              Completadas
            </button>
          </div>
        </div>

        <TaskForm onCreate={handleCreate} projects={projects} />

        <div className="chart">
          <Pie data={data} />
        </div>

        <div className="grid">
          {filteredTasks.map((t) => (
            <TaskCard
              key={t.id}
              task={t}
              onComplete={handleComplete}
              onCancel={handleCancel}
              onDelete={handleDelete}
            />
          ))}
        </div>
      </div>
    </div>
  );
}