import java.util.ArrayList;

public class Observer_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		
		weatherData.setMeasurements(80,  65,  30.4f);
		weatherData.setMeasurements(82,  70,  29.2f);
		weatherData.setMeasurements(78,  90,  29.2f);
	}

}

interface Subject{
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}

interface Observer{
	public void update(float temp, float humidity, float pressure);
}

interface DisplayElement{
	public void display();
}

class WeatherData implements Subject{

	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	WeatherData(){
		observers = new ArrayList();
	}
	
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = observers.indexOf(o);
		
		if(i >= 0)
			observers.remove(i);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i=0; i<observers.size(); i++){
			Observer ob = (Observer)observers.get(i);
			ob.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged(){
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}

class CurrentConditionsDisplay implements Observer, DisplayElement{

	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		// TODO Auto-generated constructor stub
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Current conditions : " + temperature + "F degrees and " + humidity + "% humidity");
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}
	
}