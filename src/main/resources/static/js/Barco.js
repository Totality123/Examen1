let apiURLBar = 'http://localhost:8080/barcos';

function listarBarcos() {
    fetch(apiURLBar)
        .then(response => response.json())
        .then(barcos => {
            const list = document.getElementById('Tabla-Barcos');
            list.innerHTML = "";
            console.log(barcos)
            barcos.forEach(barco => {
                list.appendChild(añadirBarcoFila(barco));
            });
        });
}

function añadirBarcoFila(barco) {
    const tr = document.createElement("tr");
    tr.innerHTML = `<td>${barco.id}</td>
                <td>${barco.nombre}</td>
                <td>${barco.origen}</td>
                <td>${barco.destino}</td>
                <td>${barco.capacidad}</td>
                <td><button class="btn delete" onclick="eliminarBarco(${barco.id})">
        🗑️
    </button >

    <button class="btn edit" onclick="openModalEditar(${barco.id})">
       ✏️
    </button>

    <button class="btn view">
        👁️
    </button> </td>
    `;
    return tr;
}

function eliminarBarco(id) {
    fetch(`${apiURLBar}/${id}`, { method: 'DELETE' })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error al eliminar el barco: ${response.status}`);
            }
            return response.text(); // Procesamos la respuesta del servidor
        })
        .then(() => listarBarcos()) // ✅ Solo llama listarBarcos() si la eliminación fue exitosa
        .catch(error => console.error("Error al eliminar barco:", error.message)); // ✅ Muestra errores en consola
}

document.addEventListener("DOMContentLoaded", () => {
    listarBarcos();
});

function openModalCrear() {
    const modal = document.getElementById("modalContainer");
    modal.style.display = "flex";
    modal.innerHTML = `<div class="modal">
        <span class="close" onclick="closeModal()">&times;</span>
        <h2>Formulario de Datos</h2>
        
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" maxlength="40" required>
            </div>
            <div class="form-group">
                <label for="origen">Origen</label>
                <input type="text" id="origen" maxlength="40" required>
            </div>
            <div class="form-group">
                <label for="destino">Destino</label>
                <input type="text" id="destino" maxlength="40" required>
            </div>
            <div class="form-group">
                <label for="capacidad">Capacidad</label>
                <input type="number" id="capacidad" required>
            </div>
            <button class="btn" onclick="guardarBarco()">guardar</button>
       
    </div>`
}

function openModalEditar(id) {
    fetch(`${apiURLBar}/${id}`)
        .then(response => response.json())
        .then(barco => {
            barco
            const modal = document.getElementById("modalContainer");
            modal.style.display = "flex";
            modal.innerHTML = `<div class="modal">
        <span class="close" onclick="closeModal()">&times;</span>
        <h2>Formulario de Datos</h2>
        
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" maxlength="40" value="${barco.nombre}" required>
            </div>
            <div class="form-group">
                <label for="origen">Origen</label>
                <input type="text" id="origen" maxlength="40"  value="${barco.destino}" required>
            </div>
            <div class="form-group">
                <label for="destino">Destino</label>
                <input type="text" id="destino" maxlength="40" value="${barco.origen}"  required>
            </div>
            <div class="form-group">
                <label for="capacidad">Capacidad</label>
                <input type="number" id="capacidad" value="${barco.capacidad}" required>
            </div>
            <button class="btn" onclick="editarBarco(${barco.id})">guardar</button>
       
    </div>`
        });

}

function guardarBarco() {
    const nombre = document.getElementById('nombre').value;
    const origen = document.getElementById('origen').value;
    const destino = document.getElementById('destino').value;
    const capacidad = document.getElementById('capacidad').value;
    fetch(apiURLBar, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nombre, origen, destino, capacidad })
    }).then(() => listarBarcos(), closeModal());
}


function editarBarco(id) {
    const nombre = document.getElementById('nombre').value;
    const origen = document.getElementById('origen').value;
    const destino = document.getElementById('destino').value;
    const capacidad = document.getElementById('capacidad').value;
    fetch(apiURLBar, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ id, nombre, origen, destino, capacidad })
    }).then(() => listarBarcos(), closeModal());
}




function closeModal() {
    const modal = document.getElementById("modalContainer")
    modal.style.display = "none";
    modal.innerHTML = "";
}