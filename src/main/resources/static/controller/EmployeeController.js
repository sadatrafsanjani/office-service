var app = angular.module('app', []);

app.controller("EmployeeController", ["$scope", "$http", function($scope, $http){

    $scope.init = function(){
        $scope.GetEmployees();
        $scope.GetDepartments();
    };

    $scope.GetEmployees = function(){

        $http.get("http://localhost:8080/api/employees")
            .then(
                function(success){
                    $scope.employees = success.data;
                },
                function(failure){
                    alert(failure.status);
                }
            );

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

    $scope.GetEmployee = function(id){

        $http.get("http://localhost:8080/api/employees/" + id)
            .then(
                function(success){
                    $scope.employee = success.data;
                },
                function(failure){
                    alert(failure.status);
                }
            );
    };

    $scope.AddEmployee = function(){

        let employee = {
            name: $scope.name,
            department: JSON.parse($scope.department),
            photo: './uploads/' + Math.random().toString(36).substr(2, 10) + '.jpg',
            joiningDate: $scope.joiningDate,
            dateOfBirth: $scope.dateOfBirth,
            designation: $scope.designation,
            basicSalary: $scope.basicSalary,
            gender: $scope.gender

        };

        $http.post("http://localhost:8080/api/employees", angular.toJson(employee))
            .then(
                function(success){
                    $scope.init();
                    $scope.name = "";
                    $scope.department = "";
                    $scope.photo = "";
                    $scope.joiningDate = "";
                    $scope.dateOfBirth = "";
                    $scope.designation = "";
                    $scope.basicSalary = "";
                    $scope.gender = "";
                },
                function(failure){
                    alert(failure.status);
                }
            );
    };

    $scope.DeleteEmployee = function(id){

        let result = confirm("Are you sure?");

        if (result) {

            $http.delete("http://localhost:8080/api/employees/" + id)
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

    $scope.EditEmployee = function(id){

        $http.get("http://localhost:8080/api/employees/" + id)
            .then(
                function(success){

                    let employee = success.data;
                    $scope.uid = employee.id;
                    $scope.uname = employee.name;
                    $scope.udepartment = employee.department.name;
                    $scope.ujoiningDate = employee.joiningDate;
                    $scope.udateOfBirth = employee.dateOfBirth;
                    $scope.udesignation = employee.designation;
                    $scope.ubasicSalary = employee.basicSalary;
                    $scope.ugender = employee.gender;
                },
                function(failure){
                    alert(failure.status);
                }
            );
    };

    $scope.UpdateEmployee = function(){

        let employee = {

            name: $scope.uname,
            department: JSON.parse($scope.udepartment),
            photo: './uploads/' + Math.random().toString(36).substr(2, 10) + '.jpg',
            joiningDate: $scope.ujoiningDate,
            dateOfBirth: $scope.udateOfBirth,
            designation: $scope.udesignation,
            basicSalary: $scope.ubasicSalary,
            gender: $scope.ugender
        };

        $http.put("http://localhost:8080/api/employees", angular.toJson(employee))
            .then(
                function(success){
                    $scope.init();
                    $scope.uname = "";
                    $scope.udepartment = "";
                    $scope.uphoto = "";
                    $scope.ujoiningDate = "";
                    $scope.udateOfBirth = "";
                    $scope.udesignation = "";
                    $scope.ubasicSalary = "";
                    $scope.ugender = "";
                },
                function(failure){
                    alert(failure.status);
                }
            );
    };

    $scope.Report = function(){

        $http.get("http://localhost:8080/api/report")
            .then(
                function(success){
                    alert('Success');
                },
                function(failure){
                    alert(failure.status);
                }
            );

    };
}
]);

