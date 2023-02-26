$(document).ready(function() {
    cargarAlumnos();
    // $('#alumnos').DataTable();
} );

async function cargarAlumnos() {
 try {
    const request = await fetch('/listar', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },

      });
    const alumnos = await request.json();
    let listadoHTML = '';
    for(let alumno of alumnos) {
        listadoHTML += ' <tr><th scope="row" id="id' + alumno.id + '">' + alumno.id + '</th><td id="name'+ alumno.id + '">' + alumno.nombre + '</td><td id="last'+ alumno.id + '">' + alumno.apellido + '</td><td id="nota' + alumno.id + '">' + alumno.nota + '</td><td id="acciones' + alumno.id + '">' + '<div class="grid grid-2 gap-1"><button onclick="changeToInput(' + alumno.id + ')"><i class="fa-solid fa-pencil"></i></button><button class="bg-danger" onclick="eliminarAlumno(' + alumno.id + ')"><i class="fa-solid fa-trash-can"></i></button></div> ' + '</td></tr>';
    }
    document.querySelector("#alumnos #tbodyAlumnos").innerHTML = listadoHTML;
    } catch (error) {
        console.log(error);
    }
}



