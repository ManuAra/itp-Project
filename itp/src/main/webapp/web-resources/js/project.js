//get modal element 
var modal = document.getElementById('chooseFile');

// get open modal button 
var btnFile = document.getElementById('btnFile');

//Listen for open click
btnFile.addEventListener('mouseout', openModal);

//Function
function openModal() {
	
	modal.style.display = 'block';
}