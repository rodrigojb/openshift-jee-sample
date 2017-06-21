myApp.service('BusquedasService', ["$http", "$rootScope","BASE", function ($http, $rootScope, BASE) {

    var self = this;

    self.buscar = function (url, textoDeBusqueda, numeroDePagina) {
        // return $http.get(BASE + 'search/' + url + textoDeBusqueda.split(' ').join('-') + '?page=' + numeroDePagina, {
          return $http.get(BASE + 'search/' + url + textoDeBusqueda.split(' ').join('-'),{
            headers: {
                "Token": $rootScope.sesionActual.idSesion
            }
        });
    };

}]);
