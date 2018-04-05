//get modal element 
var modal = document.getElementById('skillmodal');

// get open modal button 
var btnFile = document.getElementById('SkillModalBtn');

//Listen for open click
btnFile.addEventListener('click', openModal);

//Function
function openModal() {
	
	modal.style.display = 'block';
}