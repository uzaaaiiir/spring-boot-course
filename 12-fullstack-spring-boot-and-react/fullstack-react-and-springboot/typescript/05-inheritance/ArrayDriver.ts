import { Shape } from "./Shape";
import { Circle } from "./Circle";
import { Rectangle } from "./Rectangle";

let shape = new Shape(5, 10);
let circle = new Circle(5, 10, 20);
let rectangle = new Rectangle(5, 10, 20, 25);

// declare empty array of shapes
let shapes: Shape[] = [];
shapes.push(shape);
shapes.push(circle);
shapes.push(rectangle);

for (let shape of shapes) {
    console.log(shape.getInfo());
}
