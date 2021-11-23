const mostrarFrente = () => {
	if(tarjeta.classList.contains('active')){
		tarjeta.classList.remove('active');
	}
}
tarjeta.addEventListener('click', () => {
	tarjeta.classList.toggle('active');
});