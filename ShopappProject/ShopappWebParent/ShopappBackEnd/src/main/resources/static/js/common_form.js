$(document).ready(function() {
	$("#btn-cancel").on("click", function(){
		window.location = moduleURL;
	});	
	
	$('#fileImage').change(function(){
		fileSize = this.files[0].size;

		// binary
		if(fileSize > 102400){
			this.setCustomValidity("You must choose an image less than 100KB!");
			// prevent submit to server
			this.reportValidity();
		}else {
			this.setCustomValidity("");
			showImageThumnail(this);
		}
	});
});	

function showImageThumnail(fileInput){
	var file = fileInput.files[0];
	var reader = new FileReader();
	reader.onload = function(e){
		$("#thumbnail").attr("src", e.target.result);
	}
	reader.readAsDataURL(file);
}

function showDialog(title, message){
		$("#modalTitle").text(title);
		$("#modalBody").text(message);
		$("#modalDialog").modal();
	}
	
function showWarningModal(message){
	showDialog('Warning', message);
}

function showErrorModal(message){
	showDialog('Error', message);
}