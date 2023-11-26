"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const Circle_1 = require("./Circle");
const Rectangle_1 = require("./Rectangle");
let circle = new Circle_1.Circle(5, 10, 20);
let rectangle = new Rectangle_1.Rectangle(5, 10, 20, 25);
// declare empty array of shapes
let shapes = [];
shapes.push(circle);
shapes.push(rectangle);
for (let shape of shapes) {
    console.log(shape.getInfo());
    console.log(shape.calculateArea());
    console.log();
}
