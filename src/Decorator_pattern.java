
public class Decorator_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());
		
		Beverage beverage2 = new HouseBlend();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		beverage2 = new Soy(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
	}

}

abstract class Beverage{
	String description = "제목 없음";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double cost();
}

abstract class CondimentDecorator extends Beverage{
	public abstract String getDescription();
}

class Espresso extends Beverage{

	public Espresso(){
		description = "에스프레소";
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.99;
	}
	
}

class HouseBlend extends Beverage{

	public HouseBlend(){
		description = "하우스 블렌드 커피";
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .89;
	}
	
}

class Mocha extends CondimentDecorator{
	Beverage beverage;
	
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", 모카";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .20 + beverage.cost();
	}
}

class Whip extends CondimentDecorator{
	Beverage beverage;
	
	public Whip(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", 휘핑 크림";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .25 + beverage.cost();
	}
}

class Soy extends CondimentDecorator{
	Beverage beverage;
	
	public Soy(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + ", 두유";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .15 + beverage.cost();
	}
}