function register(){
	var loginName = $("#regForm .loginName").val();
	var passWord = $("#regForm .passWord_1").val();
	var userName = $("#regForm .userName").val();
	var sex = $("#regForm .sex").val();
	var identityCode = $("#regForm .identityCode").val();
	var email = $("#regForm .email").val();
	var mobile = $("#regForm .mobile").val();
	
	$.ajax({	
		url : contPath + "/register",
		method : "post",
		data : {
			action : "doRegister",
			loginName : loginName,
			passWord : passWord,
			userName : userName,
			sex : sex,
			identityCode : identityCode,
			email : email,
			mobile : mobile
		},
		dataType : "json",
		success : function(jsonStr){
			var result = jsonStr;
			if(result.status == 1){
				alert(result.message);
				window.location.href = contPath + "/login?action=toLogin";
			}else{
				alert(result.message);
			}		
		}
	
	})
	
}