myApp.config(function ($stateProvider) {
    // An array of state definitions
    var states = [{
        name: 'home',
        url: '/',
        templateUrl: 'views/home.html'
    },
        {
            name: 'login',
            url: '/login',
            controller: 'loginController',
            templateUrl: 'views/login.html'
        },
        {
            name: 'register',
            url: '/register',
            controller: 'registerController',
            templateUrl: 'views/register.html'
        },
        {
            name: 'actoresFavoritos',
            url: '/actoresFavoritos',
            templateUrl: 'views/actoresFavoritos.html'
        },
        {
            name: 'listas',
            url: '/listas',
            templateUrl: 'views/listas/list.html'
        },
        {
            name: 'buscarMovies',
            url: '/buscar/pelicula/',
            controller: 'buscarMoviesController',
            templateUrl: 'views/buscar/movies.html'
        },
        {
            name: 'users',
            url: '/users',
            templateUrl: 'views/admin/users.html'
        },

        {
            name: 'users.lists',
            url: '/lists',
            params: {
                usersSel: null
            },
            views: {
                'container@': {
                    templateUrl: 'views/admin/listComparison.html'
                }
            }
        },

        {
            name: 'fichaPelicula',
            url: '/movie/:fichaId',
            views: {
                'container@': {
                    templateUrl: 'views/fichas/pelicula.html'
                }
            }
        },
        {
            name: 'fichaPersona',
            url: '/person/:fichaId',
            views: {
                'container@': {
                    templateUrl: 'views/fichas/persona.html'
                }
            }
        },
        {
            name: 'rankingActoresFavoritos',
            url: '/ranking',
            templateUrl: 'views/admin/rankingActoresFavoritos.html'
        }
    ]

    // Loop over the state definitions and register them
    states.forEach(function (state) {
        $stateProvider.state(state);
    });

});
