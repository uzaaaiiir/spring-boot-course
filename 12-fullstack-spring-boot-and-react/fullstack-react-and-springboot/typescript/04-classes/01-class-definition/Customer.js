var Customer = /** @class */ (function () {
    function Customer(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    return Customer;
}());
// create instance
var myCustomer = new Customer("John", "Dixon");
console.log(myCustomer);
console.log("".concat(myCustomer.firstName, " ").concat(myCustomer.lastName));
