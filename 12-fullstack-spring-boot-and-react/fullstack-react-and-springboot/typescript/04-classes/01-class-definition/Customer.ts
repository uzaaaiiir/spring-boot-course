class Customer {
    firstName: string;
    lastName: string;

    constructor(firstName: string, lastName: string) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

// create instance
let myCustomer = new Customer("John", "Dixon");

console.log(myCustomer);
console.log(`${myCustomer.firstName} ${myCustomer.lastName}`);
