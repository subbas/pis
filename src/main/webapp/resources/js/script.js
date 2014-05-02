window.history.forward();
	var id = 0;
	function noBack() {
		id = 1;
		window.history.forward();
	}
	  //$(function() {
	function submitForm(){
		
		
		 $('#myForm').validate({
			rules: {        	        		
				zasobnik1Druh: "required"
				},
		   	messages: {
		    		zasobnik1Druh: " Enter Name"
		   	},
				submitHandler: function(form) {
            	form.submit();
				}
        	});
	}
		/* if(validator.form()){ // validation perform
		 	//$('form#form').attr({action: "${pageContext.request.contextPath}/add-maerz-form-velinar.html"});			
			$('form#myForm').submit();
		}  */
	
	/* function vytvorDalsiZaznam(rola) {
		if (rola == 'strojnik') {
			var tr = document.createElement("tr");
			var t1 = document.createTextNode("text");
			var t2 = document.createTextNode("text");
			var t3 = document.createTextNode("text");
			var td1 = document.createElement("td");
			var td2 = document.createElement("td");
			var td3 = document.createElement("td");
			var td4 = document.createElement("td");
			var td5 = document.createElement("td");
			var td6 = document.createElement("td");
			var odkedy = document.createElement("input");
			var dokedy = document.createElement("input");
			var popis = document.createElement("input");
			var posledny = document.getElementById("posledny");
			var teloTabulky = document.getElementById("teloTabulky");

			td1.setAttribute("class", "velinar");
			td2.setAttribute("class", "velinar");
			td3.setAttribute("class", "velinar");
			td3.setAttribute("colspan", "2");
			td4.setAttribute("class", "strojnik");
			td5.setAttribute("class", "strojnik");
			td6.setAttribute("colspan", "4");
			td6.setAttribute("class", "strojnik");
			odkedy.setAttribute("type", "text");
			odkedy.setAttribute("class", "strojnik sirka3 vstup");
			dokedy.setAttribute("type", "text");
			dokedy.setAttribute("class", "strojnik sirka3 vstup");
			popis.setAttribute("type", "text");
			popis.setAttribute("class", "strojnik sirka2 vstup");

			td1.appendChild(t1);
			td2.appendChild(t2);
			td3.appendChild(t3);
			td6.appendChild(popis);
			td5.appendChild(dokedy);
			td4.appendChild(odkedy);
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			tr.appendChild(td6);

			teloTabulky.insertBefore(tr, posledny);
		}
		if (rola == 'strojnik') {

		}
	} */