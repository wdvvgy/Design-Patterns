public class Abstract_Factory_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

		Shapes shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();

		Shapes shape2 = shapeFactory.getShape("RECTANGLE");
		shape2.draw();


		Shapes shape3 = shapeFactory.getShape("SQUARE");
		shape3.draw();

		AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

		Color color1 = colorFactory.getColor("RED");
		color1.fill();

		Color color2 = colorFactory.getColor("Green");
		color2.fill();

		Color color3 = colorFactory.getColor("BLUE");
		color3.fill();
	}

}
interface Shapes {
	void draw();
}

class Rectangles implements Shapes {

	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}
class Squares implements Shapes {

	@Override
	public void draw() {
		System.out.println("Inside Square::draw() method.");
	}
}
class Circles implements Shapes {

	@Override
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}

interface Color {
	void fill();
}

class Red implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}

class Green implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Green::fill() method.");
	}
}

class Blue implements Color {

	@Override
	public void fill() {
		System.out.println("Inside Blue::fill() method.");
	}
}

abstract class AbstractFactory {
	abstract Color getColor(String color);
	abstract Shapes getShape(String shape) ;
}

class ShapesFactory extends AbstractFactory {

	@Override
	public Shapes getShape(String shapeType){

		if(shapeType == null){
			return null;
		}		

		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circles();

		}else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangles();

		}else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Squares();
		}

		return null;
	}

	@Override
	Color getColor(String color) {
		return null;
	}
}

class ColorFactory extends AbstractFactory {

	@Override
	public Shapes getShape(String shapeType){
		return null;
	}

	@Override
	Color getColor(String color) {

		if(color == null){
			return null;
		}		

		if(color.equalsIgnoreCase("RED")){
			return new Red();

		}else if(color.equalsIgnoreCase("GREEN")){
			return new Green();

		}else if(color.equalsIgnoreCase("BLUE")){
			return new Blue();
		}

		return null;
	}
}

class FactoryProducer {
	public static AbstractFactory getFactory(String choice){

		if(choice.equalsIgnoreCase("SHAPE")){
			return new ShapesFactory();

		}else if(choice.equalsIgnoreCase("COLOR")){
			return new ColorFactory();
		}

		return null;
	}
}