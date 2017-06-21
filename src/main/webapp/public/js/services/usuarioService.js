'use strict';

myApp.service('Usuario', ["$http", "$rootScope","BASE", function ($http, $rootScope, BASE) {

    var self = this;

    self.register = function (credentials) {
        return $http.post(BASE + 'user/', credentials);
    };

    self.getRecMovies = function (sesion,callback) {
        return $http.get(BASE + 'user/favoriteactor/movies', {
            headers: {'token': sesion.idSesion}
        }).then(callback);
    }

    self.actoresFavoritos = function (credentials) {
        return $http.get(BASE + 'user/favoriteactor/',
            {
                headers: {
                    'token': $rootScope.sesionActual.idSesion
                }
            }
        );
    }

    self.marcarActorFavorito = function (actor) {
        return $http.put(BASE + 'user/favoriteactor/', actor,
            {
                headers: {
                    'token': $rootScope.sesionActual.idSesion
                }
            }
        );
    };
    self.desmarcarActorFavorito = function (actor_id) {
        return $http.put(BASE +'user/favoriteactor/' + actor_id,null,
            {
                headers: {
                    'token': $rootScope.sesionActual.idSesion
                }
            }
        );
    }

    self.getListas = function (credentials) {
        return $http.get(BASE + 'user/movieLists', {
                headers: {
                    'token': $rootScope.sesionActual.idSesion
                }
            }
        );
    };
    self.getRankingActoresFavoritos = function () {
        return $http.get(BASE +'user/favoriteactor/ranking',
            {
                headers: {
                    'token': $rootScope.sesionActual.idSesion
                }
            }
        );
    }



}]);
