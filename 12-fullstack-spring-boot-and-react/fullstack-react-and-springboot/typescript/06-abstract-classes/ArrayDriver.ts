import { Shape } from "./Shape";
import { Circle } from "./Circle";
import { Rectangle } from "./Rectangle";

let circle = new Circle(5, 10, 20);
let rectangle = new Rectangle(5, 10, 20, 25);

// declare empty array of shapes
let shapes: Shape[] = [];
shapes.push(circle);
shapes.push(rectangle);

for (let shape of shapes) {
    console.log(shape.getInfo());
    console.log(shape.calculateArea());
    console.log();
}
