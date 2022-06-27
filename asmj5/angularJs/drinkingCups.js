app.controller('homeCtrl', function ($scope, $rootScope, $http) {
    $scope.products = [];
    $scope.categories = [];
    $scope.indexCart = -1;

    $http.get('http://localhost:8080/admin/DrinkingCup/').then(function (response) {

        $scope.products = response.data;

    })

    $http.get('http://localhost:8080/public/category').then(function (response) {
        $scope.categories = eval(response.data);

    })
    $http.get('http://localhost:8080/public/category').then(function (response) {
        $scope.categories = eval(response.data);

    })



});

app.controller('detailCtrl', function ($scope, $routeParams, $route, $rootScope, $http) {
    $http.get('http://localhost:8080/admin/DrinkingCup/').then(function (response) {
        $rootScope.products = response.data;
        $rootScope.products.forEach(ar => {
            if (ar.id == $routeParams.id) {
                $scope.detail = angular.copy(ar);
                return;
            }
        });
    })

});
app.controller('shopCtrl', function ($scope, $routeParams, $route, $rootScope, $http) {
    $scope.products = [];
    $rootScope.categories.forEach(ar =>{
        alert( $rootScope.categories +"dfghjkl")
        if(ar.id == $routeParams.id){
            $http.get('http://localhost:8080/public/getDrinkingcupByCategory/' + $routeParams.id).then(function (response) {
                $scope.products = response.data;
                console.log(response.data +"res")
            })
        }
    })

});
