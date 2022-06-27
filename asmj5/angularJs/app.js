var app = angular.module("myApp", ["ngRoute", "ngCookies"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/home", {
            templateUrl: "/html/home.html", controller: "homeCtrl"
        })
        .when("/cart", {
            templateUrl: "/html/cart.html", controller: "cartCtrl"
        })
        .when("/checkout", {
            templateUrl: "/html/checkout.html", controller: "checkoutCtrl"
        })
        .when("/shop/:id", {
            templateUrl: "/html/shop.html", controller: "shopCtrl"
        })
        .when("/detail", {
            templateUrl: "/html/detail.html", controller: "detailCtrl"
        })
        .when("/signup", {
            templateUrl: "/html/register.html", controller: "signUpCtrl"
        })
        .when("/login", {
            templateUrl: "/html/login.html", controller: "loginUpCtrl"
        })
        .when("/drinkingCupsDetail/:id", {
            templateUrl: "/html/detail.html", controller: "detailCtrl"
        })
        .otherwise({ redirectTo: "/home" });
});