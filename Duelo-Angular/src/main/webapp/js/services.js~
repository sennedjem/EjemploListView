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
			  	 path:'img/drow.jpg',
			  	 estadisticas:{'Jugadas':'6', 'Ganadas':'2', 'Kills':'0', 'Deads':'1', 'Assists':'3', 'MejorUbicacion':'TOP', 'Puntaje':'C'},
			  	 caracteristicas:{'Habilidades':['Curación rápida'], 'Debilidades':['Magia'], 'MejorPosicion': 'TOP'}
			  	},
			  	{
			  	 id:'Amumu',
			  	 path:'img/amumu.jpg',
			  	 estadisticas:{'Jugadas':'8', 'Ganadas':'3', 'Kills':'2', 'Deads':'1', 'Assists':'4', 'MejorUbicacion':'JUNGLE', 'Puntaje':'C'},
			  	 caracteristicas:{'Habilidades':['Regeneración'], 'Debilidades':['Golpes potentes'], 'MejorPosicion':'JUNGLE'}
			  	},
			  	{
			  	 id:'Mirana',
			  	 path:'img/mirana.jpg',
			  	 estadisticas:{'Jugadas':'9', 'Ganadas':'8', 'Kills':'8', 'Deads':'0', 'Assists':'1', 'MejorUbicacion':'TOP', 'Puntaje':'A'},
			  	 caracteristicas:{'Habilidades':['Armadura', 'Golpe'], 'Debilidades':['Brujería'], 'MejorPosicion':'TOP'}
			  	},
			  	{
			  	 id:'Pudge',
			  	 path:'img/pudge.jpg',
			  	 estadisticas:{'Jugadas':'7', 'Ganadas':'5', 'Kills':'2', 'Deads':'2', 'Assists':'1', 'MejorUbicacion':'BOT', 'Puntaje':'A'},
			  	 caracteristicas:{'Habilidades':['Super velocidad'], 'Debilidades':['Ambientes aireados', 'Ataque de diamantes'], 'MejorPosicion':'BOT'}
			  	},
			  	{
			  	 id:'Shadow',
			  	 path:'img/shadow.jpg',
			  	 estadisticas:{'Jugadas':'10', 'Ganadas':'10', 'Kills':'10', 'Deads':'0', 'Assists':'0', 'MejorUbicacion':'TOP', 'Puntaje':'A'},
			  	 caracteristicas:{'Habilidades':['Mayor potencia con espada'], 'Debilidades':['Encierro'], 'MejorPosicion':'TOP'}
			  	},
			  	{
			  	 id:'Skywrath',
			  	 path:'img/skywrath.jpg',
			  	 estadisticas:{'Jugadas':'11', 'Ganadas':'10', 'Kills':'5', 'Deads':'1', 'Assists':'0', 'MejorUbicacion':'MID', 'Puntaje':'B'},
			  	 caracteristicas:{'Habilidades':['Escudo'], 'Debilidades':['Espada'], 'MejorPosicion':'MID'}
			  	}]
			}
	}
	this.findPosiciones = function(aEjecutar){
		aEjecutar( [{nombre:'TOP'}, {nombre:'BOT'}, {nombre:'JUNGLE'}, {nombre:'MID'}] )
	}
			

		this.findPosiciones = function(callback) {
        $http.get('/posiciones').then(callback);
    	}
    	
})


