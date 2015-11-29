angular.module('dueloDeLeyendasApp')
.directive('footerData', function() {
	  return {
		  templateUrl: 'footer.html'
	  };
	})
.directive('panelDeJuegoData', function() {
	  return {
		  templateUrl: 'panelDeJuego.html'
	  };
	})
.directive('ganasteData', function(){
	return {
		templateUrl: 'ganaste.html'
	};
})

.directive('statsJugarData', function(){
	return {
		templateUrl: 'panelStatsJugar.html'
	};
})
.directive('habilidadesData', function(){
	return{
		templateUrl: 'panelHabilidades.html'
	}
})
.directive('perdisteData', function(){
	return{
		templateUrl: 'perdiste.html'
	}
})
.directive('noHayRivalData', function(){
	return{
		templateUrl: 'noHayRival.html'
	}
})
;