var app = angular.module('app', []);

app.controller("DepartmentController", ["$scope", "$http", function($scope, $http){

    $scope.init = function(){
        $scope.GetDepartments();
    };

    $scope.GetDepartments = function(){

        $http.get("http://localhost:8080/api/departments")
            .then(
                function(success){
                    $scope.departments = success.data;
                },
                function(failure){
                    alert(failure.status);
                }
            );

    };

    $scope.GetDepartment = function(id){

        $http.get("http://localhost:8080/api/departments/" + id)
            .then(
                function(success){
                    $scope.department = success.data;
                },
                function(failure){
                    alert(failure.status);
                }
            );
    };



    $scope.AddDepartment = function(){

        let department = {
            name: $scope.name,
            departmentCode: $scope.departmentCode,
            active: true
        };

        $http.post("http://localhost:8080/api/departments", angular.toJson(department))
            .then(
                function(success){
                    $scope.init();
                    $scope.name = "";
                    $scope.departmentCode = "";
                },
                function(failure){
                    alert(failure.status);
                }
            );
    };

    $scope.DeleteDepartment = function(id){

        let result = confirm("Are you sure?");

        if (result) {

            $http.delete("http://localhost:8080/api/departments/" + id)
                .then(
                    function(success){
                        $scope.init();
                    },
                    function(failure){
                        alert(failure.status);
                    }
                );
        }
    };

    $scope.EditDepartment = function(id){

        $http.get("http://localhost:8080/api/departments/" + id)
            .then(
                function(success){
                    let department = success.data;
                    $scope.uid = department.id;
                    $scope.uname = department.name;
                    $scope.udepartmentCode = department.departmentCode;
                    $scope.uactive = department.active;
                },
                function(failure){
                    alert(failure.status);
                }
            );
    };

    $scope.UpdateDepartment = function(){

        if($scope.uactive == "active"){
            $scope.uactive = true;
        }
        else{
            $scope.uactive = false;
        }

        let department = {
            id: $scope.uid,
            name: $scope.uname,
            departmentCode: $scope.udepartmentCode,
            active: $scope.uactive
        };

        $http.put("http://localhost:8080/api/departments", angular.toJson(department))
            .then(
                function(success){
                    $scope.init();
                    $scope.uid = "";
                    $scope.uname = "";
                    $scope.udepartmentCode = "";
                    $scope.uactive = "";
                },
                function(failure){
                    alert(failure.status);
                }
            );
    };
}
]);

