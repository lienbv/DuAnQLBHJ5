var app = angular.module("myAppAdmin", ["ngRoute", "ngCookies"]);

app.config(function ($routeProvider) {
    $routeProvider
        
        .when("/drinkingCups", {
            templateUrl: "/html/admin/drinkingCups.html", controller: "drinkingCupsCtrl"
        })
        .when("/createDrinkingCups/:id", {
            templateUrl: "/html/admin/createDrinkingCups.html", controller: "createDrinkingCupsCtrl"
        })
        .otherwise({ redirectTo: "/drinkingCups" });
});

app.controller('drinkingCupsCtrl', function ($scope, $rootScope, $http) {
   
    $scope.products = [];
    $http.get("http://localhost:8080/admin/DrinkingCup/").then(function (response) {
        $scope.products = response.data;

    })
});

app.controller('createDrinkingCupsCtrl', function ($rootScope, $scope, $http, $routeParams) {
    $scope.categories=[];
    $http.get("http://localhost:8080/admin/DrinkingCup/").then(function (response) {
        $rootScope.products = response.data;
        $rootScope.products.forEach(ar => {
            if (ar.id == $routeParams.id) {
                $scope.from = angular.copy(ar);
                return;
            }
        });
    
    })
    $http.get("http://localhost:8080/admin/category/").then(function(response){
        $scope.categories = response.data;
    })

    $scope.updateDrinkingCups = function () {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/admin/DrinkingCup/' + $scope.from.id,
            data:  $scope.from

        })
            .then(function (response) {

                Swal.fire({
                    icon: 'success',
                    title: 'Update sản phẩm thành công',
                    text: 'Quay lại trang chủ!',
                    showConfirmButton: false,
                    closeOnClickOutside: false,
                    allowOutsideClick: false,
                    timer: 1600
                });
                window.location.href = "#!home";
            });
    };


// =======================================================
    $scope.imageChanged = function(files){
    var data = new FormData();
    data.append('file', files[0]);

    $http.post("http://localhost:8080/rest/imager/upload/img",data, {
        transformRequest: angular.identity,
        headers: {
            'Content-Type': undefined
        }
    }).then(response=>{
        $scope.from.img = response.data.name;
    }).catch(error =>{
       alert("Lỗi upload")
       console.log("Error",error);
    });
    }


})


