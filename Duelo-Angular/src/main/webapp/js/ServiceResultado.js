var ganasteApp = angular.module('ganasteApp');
ganasteApp.service('ServiceResultado', function(){
	this.resultadoDelJuego=function(){
		return{	
				 iniciador: 'sepi',
				 retado: 'marco Reus',
				 iniciadorPersonaje: {
			  	 id:'Pudge',
			  	 path:'img/pudge.jpg',
			  	 estadisticas:{'Jugadas':'7', 'Ganadas':'5', 'Kills':'2', 'Deads':'2', 'Assists':'1', 'MejorUbicacion':'BOT', 'Puntaje':'A'},
			  	 caracteristicas:{'Habilidades':['Super velocidad'], 'Debilidades':['Ambientes aireados', 'Ataque de diamantes'], 'MejorPosicion':'BOT'}
			  	}
				perdedorPersonaje: {
			  	 id:'Mirana',
			  	 path:'img/mirana.jpg',
			  	 estadisticas:{'Jugadas':'9', 'Ganadas':'8', 'Kills':'8', 'Deads':'0', 'Assists':'1', 'MejorUbicacion':'TOP', 'Puntaje':'A'},
			  	 caracteristicas:{'Habilidades':['Armadura', 'Golpe'], 'Debilidades':['Brujería'], 'MejorPosicion':'TOP'}
			  	}
				 poderAtaqueIniciador: '60'
				 poderAtaqueRetado: '12'
				 }
	}
}
)+