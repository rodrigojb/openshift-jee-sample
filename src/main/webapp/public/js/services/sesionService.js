'use strict';

myApp.service('Sesion', ["$http", "$rootScope","BASE", function ($http, $rootScope, BASE) {

    var self = this;

    self.login = function (credentials) {
        return $http.post(BASE + 'authentication/login', credentials);
    };

    self.logout = function () {
        return $http.put(BASE + 'authentication/logout',undefined,{headers: {"token": $rootScope.sesionActual.idSesion}})
    };

}]);
