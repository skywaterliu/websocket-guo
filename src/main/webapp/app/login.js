/**
 * Created by jms on 2017/10/15.
 * 登陆
 */
angular.module("ls.login",[]);

angular.module("ls.login").controller('loginController',loginController);

function loginController($scope, $rootScope, $http, $log) {

    $scope.login = function () {
        if (!$scope.logincode || !$scope.passwd) {
            alert("用户名或密码错误！");
            return;
        }

        $http.post("userLogin", {logincode: $scope.logincode, passwd: $scope.passwd}).success(function(response){
            $log.debug(response);
            if (response.success) {
                window.location.href = "./";
                $rootScope.user = response.data;
            }
            else {
                $log.debug("[返回异常]登录异常");
                alert(response.errormsg);
            }
        });
    };
    $scope.enterLogin = function (event) {
        if (event.keyCode == 13) {
            $scope.login();
        }
    };

}
