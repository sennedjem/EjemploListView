dueloApp = angular.module('dueloDeLeyendasApp')
dueloApp.controller('DueloController', function($scope, ServiceJuego) { 

  $scope.datosDelJuego = ServiceJuego.datosDelJuego();

  ServiceJuego.findPosiciones( function(listaPosiciones) {
    $scope.posiciones = listaPosiciones
  });

  $scope.personajes = ServiceJuego.datosDelJuego().personajes;
  $scope.personajeActual=$scope.datosDelJuego.personajeActual;
  $scope.nombre=$scope.personajeActual.id;

  $scope.resultado = 2;

  $scope.mifoto =function (personaje) {
         $scope.personajeActual=personaje;
         };

  $scope.determinarModal = function() {
    ServiceJuego.determinarResultado( function(resultadoServer) {
        $scope.resultado = resultadoServer  
        procesarResultado()
      }
    )
  }

  function procesarResultado()
  {
    if ($scope.resultado){
      $scope.modalposta ="#ganaste";
    }
  }
	      
});