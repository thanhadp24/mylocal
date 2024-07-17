$('.del').click(function() {
	let id = $(this).attr('role-id');
	let row = $(this).closest('tr');
	var request = $.ajax({
		url: "http://localhost:8080/crm/api/roles",
		method: "POST",
		data: { id: id },
	});

	request.done(function(data) {
		if (data.isSuccess) {
			row.remove();
		} else {
			alert('failed to deleted ' + data);
		}
	})

})

$('#add-role').click(function(e) {
	e.preventDefault();
	let name = $('#name').val();
	let desc = $('#desc').val();
	var request = $.ajax({
		url: "http://localhost:8080/crm/api/roles/add",
		method: "POST",
		data: { name: name, desc: desc },
	});

	request.done(function(data) {
		alert('add successfully');
	})

})