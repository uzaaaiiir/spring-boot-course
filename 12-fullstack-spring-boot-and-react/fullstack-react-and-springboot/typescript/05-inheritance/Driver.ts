import { Shape } from "./Shape";
import { Circle } from "./Circle";
import { Rectangle } from "./Rectangle";

let shape = new Shape(5, 10);
console.log(shape.getInfo());

let circle = new Circle(5, 10, 20);
console.log(circle.getInfo());

let rectangle = new Rectangle(5, 10, 20, 25);
console.log(rectangle.getInfo());
