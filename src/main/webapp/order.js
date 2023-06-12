angular.module('app', []).controller('indexController', function ($scope, $http) {
const contextPath = 'http://localhost:8185/AstonUbuntu';

    $scope.loadOrders = function () {
        $http.get(contextPath + '/orders')
            .then(function (response) {
                $scope.OrdersList = response.data;
            });
    };



    $scope.loadOrders();

});