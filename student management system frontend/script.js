const API_BASE = "http://localhost:8080/student";

document.getElementById("studentForm").addEventListener("submit", async function (e) {
  e.preventDefault();
  const form = e.target;
  const student = {
    name: form.name.value,
    percentage: parseFloat(form.percentage.value),
    branch: form.branch.value
  };

  const rollno = form.rollno.value;
  const method = rollno ? "PUT" : "POST";
  const url = rollno
    ? `${API_BASE}/update/${rollno}`
    : `${API_BASE}/addstudent`;

  await fetch(url, {
    method: method,
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(student)
  });

  form.reset();
  loadStudents();
});

async function loadStudents() {
  const response = await fetch(`${API_BASE}/viewall`);
  const students = await response.json();
  const tbody = document.querySelector("#studentTable tbody");
  tbody.innerHTML = "";

  students.forEach(student => {
    const row = `
      <tr>
        <td>${student.rollno}</td>
        <td>${student.name}</td>
        <td>${student.percentage}</td>
        <td>${student.branch}</td>
        <td>
          <button onclick="deleteStudent(${student.rollno})">Delete</button>
        </td>
      </tr>
    `;
    tbody.innerHTML += row;
  });
}

async function deleteStudent(rollno) {
  await fetch(`${API_BASE}/del/${rollno}`, { method: "DELETE" });
  loadStudents();
}

// Load students when the page starts
loadStudents();