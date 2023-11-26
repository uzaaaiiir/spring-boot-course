"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const Shape_1 = require("./Shape");
const Circle_1 = require("./Circle");
const Rectangle_1 = require("./Rectangle");
let shape = new Shape_1.Shape(5, 10);
let circle = new Circle_1.Circle(5, 10, 20);
let rectangle = new Rectangle_1.Rectangle(5, 10, 20, 25);
// declare empty array of shapes
let shapes = [];
shapes.push(shape);
shapes.push(circle);
shapes.push(rectangle);
for (let shape of shapes) {
    console.log(shape.getInfo());
}
