/* When the user clicks on the button toggle between  hiding and showing the dropdown content  */
function myFunction() {
	
	document.getElementById("drop").classList.toggle("show");
	
}

/* Close the dropdown if the user clicks outside of it   */
window.onclick = function(event) {
	
	if (!event.target.matches('.dropImg')) {
		
		var dropdowns = document.getElementByClassName("drop-content");
		var i;
		for (i=0; i < dropdowns.lenght; i++) {
			var openDropdown = dropdowns[i];
			if (openDropdown.classList.contains('show')) {
				openDropdown.classList.remove('show');
			}
		}
	}
}