'use strict';

myApp.service('Admin', ["$http", "BASE", function ($http, BASE) {

    var self = this;

    self.getUsers = function (sesionActual, callback) {
        return $http.get(BASE +'admin/user/list', {
            headers: {'token': sesionActual.idSesion}
        }).then(callback);
    }

    self.getData = function (sesionActual, id, callback) {
        return $http.get(BASE +'admin/user/' + id, {
            headers: {'token': sesionActual.idSesion}
        }).then(callback);
    }

}]);
