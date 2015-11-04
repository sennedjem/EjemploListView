angular.module('ganasteApp')
.controller('ResultadoController', function($scope, ServiceResultado) { 
  $scope.resultadoDelJuego = ServiceResultado.resultadoDelJuego();
  $scope.ganador=ServiceResultado.datosDelJuego().iniciador;
  $scope.ganador=ServiceResultado.datosDelJuego().retado;
  });