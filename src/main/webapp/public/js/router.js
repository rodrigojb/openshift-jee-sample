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
            templateUrl: 'templates/actoresFavoritos.html'
        },
        {
            name: 'listas',
            url: '/listas',
            templateUrl: 'templates/listas/list.html'
        },

        {
            name: 'buscarMovies',
            url: '/buscar/pelicula/',
            controller: 'buscarMoviesController',
            views: {
                'container@': {
                    templateUrl: 'templates/buscar/movies.html'
                }
            }
        },

        {
            name: 'users',
            url: '/users',
            views: {
                'container@': {
                    templateUrl: 'templates/admin/users.html'
                }
            }
        },

        {
            name: 'users.lists',
            url: '/lists',
            params: {
                usersSel: null
            },
            views: {
                'container@': {
                    templateUrl: 'templates/admin/listComparison.html'
                }
            }
        },

        {
            name: 'fichaPelicula',
            url: '/movie/:fichaId',
            views: {
                'container@': {
                    templateUrl: 'templates/fichas/pelicula.html'
                }
            }
        },

        {
            name: 'fichaPersona',
            url: '/person/:fichaId',
            views: {
                'container@': {
                    templateUrl: 'templates/fichas/persona.html'
                }
            }
        },
        {
            name: 'rankingActoresFavoritos',
            url: '/ranking',
            views: {
                'container@': {
                    templateUrl: 'templates/admin/rankingActoresFavoritos.html'
                }
            }
        }

    ]

    // Loop over the state definitions and register them
    states.forEach(function (state) {
        $stateProvider.state(state);
    });

});
