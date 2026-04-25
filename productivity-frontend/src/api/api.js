import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api",
});

export const getTasks = () => API.get("/tasks");
export const createTask = (data) => API.post("/tasks", data);
export const completeTask = (id) => API.patch(`/tasks/${id}/complete`);
export const cancelTask = (id) => API.patch(`/tasks/${id}/cancel`);
export const deleteTask = (id) => API.delete(`/tasks/${id}`);

export const getProjects = () => API.get("/projects");
export const createProject = (data) => API.post("/projects", data);

export const getUsers = () => API.get("/users");

export default API;