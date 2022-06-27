app.controller('cartCtrl', function ($scope, $rootScope, $http) {
    $scope.cart = {
        items: [],


        add(id) {
            var item = this.items.find(item => item.id == id);
            if (item) {
                item.amount++;
                this.saveLocalStorage()
            } else {
                $http.get(`http://localhost:8080/public/DrinkingCup/${id}`).then(response => {
                    response.data.amount = 1;
                    this.items.push(response.data);
                    this.saveLocalStorage();
                })
            }
        },
        remove(id) {
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index, 1);
            this.saveLocalStorage();
        },

        clear() {
            this.items = [];
            this.saveLocalStorage();
        },
        get count() {
            return this.items.map(item => item.amount).reduce((total, amount) => total += amount, 0);
        },
        get amount() {
            return this.items.map(item => item.amount * item.price).reduce((total, amount) => total += amount, 0);
        },
        total(item) { },

        saveLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },
        loadFromLocalStorage() {
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : []
        }

    }
    $scope.cart.loadFromLocalStorage();

});
app.controller('checkoutCtrl', function ($scope, $rootScope, $http) {
    items: [],
        $scope.cart = {
            items: [],

            get count() {
                return this.items.map(item => item.amount).reduce((total, amount) => total += amount, 0);
            },
            get amount() {
                return this.items.map(item => item.amount * item.price).reduce((total, amount) => total += amount, 0);
            },
            total(item) { },
            loadFromLocalStorage() {
                var json = localStorage.getItem("cart");
                this.items = json ? JSON.parse(json) : []
            }

        }
    $scope.cart.loadFromLocalStorage();
    $scope.order = {

        createDate: new Date(),
        description: "hello",
        idUser: 1 ,
        total: 0.0,
        status: "Xác nhận",
        get orderDetails() {
          
            return $scope.cart.items.map(item => {
                return {
                    idProduct: { id: item.id },
                }
            })
        },
        puchase() {
            alert("đặt hàng")
            var order = angular.copy(this);
            $http.post("http://localhost:8080/rest/order", order).then(resp => {
                alert('Đặt thành công', resp.data);

            }).catch(error => {
                alert("lỗi")
                console.log(error)
            })
        }
    }

});