async function eliminarAlumno(id) {
    try {
        const request = await fetch(`/eliminar/${id}`, {
            method: 'DELETE'
        });
        cargarAlumnos();
    } catch (error) {
        console.log(error);
    }
}