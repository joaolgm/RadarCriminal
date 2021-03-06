const app = angular.module('jukeboxApp', ['ui.router', 'ngToast', 'jkAngularRatingStars']);

app.config(function ($stateProvider, $urlRouterProvider, $httpProvider) {
    $httpProvider.interceptors.push('httpRequestInterceptor');
    $urlRouterProvider.otherwise('/home/musicas');
    $stateProvider
        .state('login', {
            url: '/',
            controller: 'authController',
            controllerAs: 'authCtrl',
            templateUrl: 'templates/views/login.html'
        }).state('home', {
            url: '/home',
            abstract: true,
            controller: 'userController',
            controllerAs: 'userCtrl',
            templateUrl: 'templates/views/home.html',
            resolve: {
                usuario: function(UsuarioService) {
                    return UsuarioService.recuperarUsuarioAtual()
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                }
            }
        }).state('home.musicas', {
            url: '/musicas',
            controller: 'musicaController',
            controllerAs: 'musicaCtrl',
            templateUrl: 'templates/views/musica.html',
            resolve: {
                artistas: function(ArtistaService) {
                    return ArtistaService.listarArtistas()
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                }
            }
        }).state('home.artistas', {
            url: '/artistas',
            controller: 'artistaController',
            controllerAs: 'artistaCtrl',
            templateUrl: 'templates/views/artista.html',
            resolve: {
                artistas: function(ArtistaService) {
                    return ArtistaService.listarArtistas()
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                }
            }
        }).state('home.perfil', {
            url: '/perfil/:artistaId',
            controller: 'artistaPerfilController',
            controllerAs: 'perfilCtrl',
            templateUrl: 'templates/views/artista-perfil.html',
            resolve: {
                artista: function($stateParams, ArtistaService) {
                    return ArtistaService.recuperarArtista($stateParams.artistaId)
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                },
                musicas: function($stateParams, MusicaService) {
                    return MusicaService.listarMusicasPorArtista($stateParams.artistaId)
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                },
                musicaOuvida: function($stateParams, OuvirService) {
                    return OuvirService.ultimaOuvida($stateParams.artistaId)
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                },
                albums: function($stateParams, AlbumService) {
                    return AlbumService.buscaAlbumPorArtista($stateParams.artistaId)
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                },
                avaliacaoArtista: function($stateParams, ArtistaService) {
                    return ArtistaService.recuperarAvaliacao($stateParams.artistaId)
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                },
            }
        }).state('home.playlists', {
            url: '/playlists',
            controller: 'playlistController',
            controllerAs: 'playlistCtrl',
            templateUrl: 'templates/views/playlist.html',
            resolve: {
                musicas: function(MusicaService) {
                    return MusicaService.listarMusicas()
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                },
                playlists: function(PlaylistService) {
                    return PlaylistService.listarPlaylists()
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                }
            }
        }).state('home.detalhesPlaylist', {
            url: '/detalhes/:idPlaylist',
            controller: 'playlistDetalhesController',
            controllerAs: 'detalhesCtrl',
            templateUrl: 'templates/views/playlist-detalhes.html',
            resolve: {
                playlist: function($stateParams, PlaylistService) {
                    return PlaylistService.buscaPlaylistPorId($stateParams.idPlaylist)
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                },
                musicas: function(MusicaService) {
                    return MusicaService.listarMusicas()
                        .catch((error) => {
                            console.log("Ocorreu um erro");
                            console.log(error);
                        });
                }
            }
        });
});

app.factory('httpRequestInterceptor', function ($rootScope, $window, $state, $q) {
    return {
        'request': function ($config) {
            const token = $window.sessionStorage.token;
            if (token) {
                $config.headers['Authorization'] = token;
            }
            return $config;
        },
        'responseError': function(response) {
            let q = $q.defer();
            if (response.status == 403) {
                delete $window.sessionStorage.token;
                $state.go("login");
            }
            if (response.status == 401) {
                response.data.message = "Login ou senha incorretos";
            }
            q.reject(response);
            return q.promise;
        },
    };
});