app.controller('signUpCtrl', function ($scope, $rootScope, $http, $cookies) {

    $scope.register = function () {
        var postData = angular.toJson($scope.formModel, true);
        $http.post("http://localhost:8080/public/register", {
            "fullname": $scope.user.fullname,
            "username": $scope.user.username,
            "password": $scope.user.password,
            "address": $scope.user.address,
            "email": $scope.user.email,
            "phoneNumber": $scope.user.phoneNumber,
      
        })
            .then(function (response) {

                Swal.fire({
                    icon: 'success',
                    title: 'Đăng kí thành công!',
                    text: 'Quay lại trang chủ!',
                    showConfirmButton: false,
                    closeOnClickOutside: false,
                    allowOutsideClick: false,
                    timer: 1600
                });
                window.location.href = "#!home";
            });
    };
   

    $scope.cancel = function () {
        $scope.studentUniver = {};
        $scope.index = -1
    }

});