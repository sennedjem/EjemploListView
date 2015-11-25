'use strict';

var app = angular.module('dueloDeLeyendasApp',[]);

app.factory('DueloRest', function($http) {
    return function(errorHandler) {
        this.findPosiciones = function(callback) {
            $http.get('/posiciones').success(callback);
        }
    }

    return function(errorHandler) {
        this.findPersonajes = function(callback) {
            $http.get('/personajes').success(callback);
        }
    }
});

app.controller('DueloCtrl', function ($scope, $http) {
	$scope.findPosiciones = function(callback) {
        $http.get('/posiciones').success(callback);
    	};

    $scope.findPosiciones(function(data) {
		$scope.posiciones = data;
	});

    $scope.findPersonajes = function(callback) {
        $http.get('/personajes').success(callback);
        };

    $scope.findPersonajes(function(data) {
        $scope.personajes = data;
        $scope.personajeActual = data[1];
    });

    $scope.mifoto= function(pers){
        $scope.personajeActual=pers;
    }
});