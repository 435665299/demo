function login() {
	var loginName = $("#loginName").val();
	var password = $("#password").val();
	$.ajax({
		url : contPath + "/login",
		method : "post",
		data : {
			loginName : loginName,
			password : password,
			action : "login"
		},
		dataType : "json",
		success : function(jsonStr) {
			if (jsonStr.status == 1) {
				window.location.href = contPath + "/home?action=index";
			} else {
				alert(jsonStr.message);
			}
		}

	})

}