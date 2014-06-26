		

function mostrarHora(timeoutPeriod){ 
			   	var data = new Date();
			   	
			   	var hora = data.getHours();          // 0-23
			   	var min = data.getMinutes();        // 0-59
			   	var seg = data.getSeconds();        // 0-59
			   	
			   	var str_hora = hora + ':' + min + ':' + seg;
			   	
			   	alert(str_hora);
			   	
			} 