"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Customer_1 = require("./Customer");
// create instance
var myCustomer = new Customer_1.Customer("John", "Dixon");
console.log(myCustomer);
console.log("".concat(myCustomer.firstName, " ").concat(myCustomer.lastName));
