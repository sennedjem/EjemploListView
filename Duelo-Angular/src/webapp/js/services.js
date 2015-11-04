var dueloApp = angular.module('dueloDeLeyendasApp');
dueloApp.service('ServiceJuego', function() { 
	this.datosDelJuego = function() {
		return {
			posicionesDuelos:[{nombre:'TOP'}, {nombre:'BOT'}, {nombre:'JUNGLE'}, {nombre:'MID'}],
				personajeActual:{
					id:'Drow',
			  		 path:'img/drow.jpg',
			  	 	estadisticas:{'Jugadas':'6', 'Ganadas':'2', 'Kills':'0', 'Deads':'1', 'Assists':'3', 'Mejor Ubicacion':'TOP', 'Puntaje':'D'},
			  	 	caracteristicas:{'Habilidades':['Curación rápida'], 'Debilidades':['Magia'], 'MejorPosicion': 'TOP'}
				},
			  	personajes:[
			  	{
			  	 id:'Drow',
			  	 path:'img/amumu_0.jpg',
			  	 estadisticas:{'Jugadas':'6', 'Ganadas':'2', 'Kills':'0', 'Deads':'1', 'Assists':'3', 'MejorUbicacion':'TOP', 'Puntaje':'C'},
			  	 caracteristicas:{'Habilidades':['Curación rápida'], 'Debilidades':['Magia'], 'MejorPosicion': 'TOP'}
			  	}

				], 


			}
	}
	this.findPosiciones = function(aEjecutar){
		aEjecutar( [{nombre:'TOP'}, {nombre:'BOT'}, {nombre:'JUNGLE'}, {nombre:'MID'}] )
	}
		/*
			

		this.findPosiciones = function(callback) {
        $http.get('/posiciones').then(callback);
    	}
    	*/
})


