let apiURLCont='http://localhost:8080/contenedores';

function listarcontenedores(id) {
    fetch(`${apiURLCont}/barco/${id}`)
        .then(response => response.json())
        .then(contenedores => {
            const list = document.getElementById('Tabla-Barcos');
            list.innerHTML = "";
            console.log()
            contenedores.forEach(contenedor => {
                list.appendChild(añadirContenedorFila(contenedor));
            });
        });
}

function añadirContenedorFila(barco){
    const tr =document.createElement("tr");
    tr.innerHTML=`<td>${barco.id}</td>
                <td>${barco.vin}</td>
                <td>${barco.fecha}</td>
                <td>${barco.barco.id}</td>         
    `;
    return tr;
}


