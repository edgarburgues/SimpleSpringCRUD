async function insertarAlumno2() {
    const nombre = document.getElementById('firstname').value;
    const apellido = document.getElementById('lastname').value;
    const nota = document.getElementById('nota').value;
    try {
        const request = await fetch(`/insertar/${nombre}/${apellido}/${nota}`, {
            method: 'GET'
        });
        cargarAlumnos();
    } catch (error) {
        console.log(error);
    }
}

function showInsertar() {
    if (document.getElementById('formInsertar').style.display === 'flex') {
        document.getElementById('formInsertar').style.display = 'none';
        document.getElementById('btnShowInsert').innerHTML = '<i class="fa-solid fa-plus"></i>';
    } else {
        document.getElementById('formInsertar').style.display = 'flex';
        document.getElementById('btnShowInsert').innerHTML = '<i class="fa-solid fa-minus"></i>';
    }
}