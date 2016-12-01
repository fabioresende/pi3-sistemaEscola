var controle = false;
function trazerMenuFrente(){
	if(controle == false){
	var menu = document.getElementById('sub-menu').className="trazer-frente";
	controle = true;
	}
	else{
		var menu = document.getElementById('sub-menu').className="sub-menu";
		controle=false;
	}
}