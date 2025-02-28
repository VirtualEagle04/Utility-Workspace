function sumarNum(){
	let num1 = document.getElementById("input-num1").value;
	let num2 = document.getElementById("input-num2").value;
	let suma = parseInt(num1) + parseInt(num2);
	
	document.getElementById("result").value = suma;
	if(suma < 0 ){
		document.getElementById("result").classList.add("text-danger");
		document.getElementById("result").classList.remove("text-success");
	}
	else{
		document.getElementById("result").classList.remove("text-danger");
		document.getElementById("result").classList.add("text-success");
	}
}

function restarNum(){
	let num1 = document.getElementById("input-num1").value;
	let num2 = document.getElementById("input-num2").value;
	let resta = num1 - num2;
	
	document.getElementById("result").value = resta;
	if(resta < 0 ){
		document.getElementById("result").classList.add("text-danger");
		document.getElementById("result").classList.remove("text-success");
	}
	else{
		document.getElementById("result").classList.remove("text-danger");
		document.getElementById("result").classList.add("text-success");
	}
}

function multiplicarNum(){
	let num1 = document.getElementById("input-num1").value;
	let num2 = document.getElementById("input-num2").value;
	let multi = num1 * num2;
	
	document.getElementById("result").value = multi;
	if(multi < 0 ){
		document.getElementById("result").classList.add("text-danger");
		document.getElementById("result").classList.remove("text-success");
	}
	else{
		document.getElementById("result").classList.remove("text-danger");
		document.getElementById("result").classList.add("text-success");
	}
}

function dividirNum(){
	let num1 = document.getElementById("input-num1").value;
	let num2 = document.getElementById("input-num2").value;
	let div = num1 / num2;
	
	document.getElementById("result").value = div;
	if(div < 0 ){
		document.getElementById("result").classList.add("text-danger");
		document.getElementById("result").classList.remove("text-success");
	}
	else{
		document.getElementById("result").classList.remove("text-danger");
		document.getElementById("result").classList.add("text-success");
	}
}