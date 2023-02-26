function changeToInput(id) {
    let row = document.getElementById("id" + id);

    let firstName = document.getElementById("name" + id);
    let lastName = document.getElementById("last" + id);
    let nota = document.getElementById("nota" + id);
    let acciones = document.getElementById("acciones" + id);

    firstName.innerHTML = '<input type="text" id="nameInput' + id + '" value="' + firstName.innerHTML + '">';
    lastName.innerHTML = '<input type="text" id="lastInput' + id + '" value="' + lastName.innerHTML + '">';
    nota.innerHTML = '<input type="text" id="notaInput' + id + '" value="' + nota.innerHTML + '">';
    acciones.innerHTML = '<div class="grid grid-2 gap-1"> <button onclick="updateAlumno(' + id + ')"><i class="fa-regular fa-floppy-disk"></i></button>' + '<button class="bg-danger" onclick="cancelUpdate()"><i class="fa-solid fa-xmark"></i></button> </div>';

}

function cancelUpdate() {
    cargarAlumnos();
}

async function updateAlumno(id) {
    let firstName = document.getElementById("nameInput" + id).value;
    let lastName = document.getElementById("lastInput" + id).value;
    let nota = document.getElementById("notaInput" + id).value;

    const alumno = {
        id: id,
        nombre: firstName,
        apellido: lastName,
        nota: nota
    }

    try {
        const request = await fetch(`/actualizar/${id}/${firstName}/${lastName}/${nota}`, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(alumno)
        });
        cargarAlumnos();
    } catch (error) {
        console.log(error);
    }
}