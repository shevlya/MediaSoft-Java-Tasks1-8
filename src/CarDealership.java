import java.util.*;
import java.util.stream.Collectors;

enum CarType { SEDAN, SUV, ELECTRIC, HATCHBACK, TRUCK }

class CarWithType extends Car{
    private final CarType type;
    public CarWithType(String vin, String model, String manufacturer, int year, int mileage, double price, CarType type){
        super(vin, model, manufacturer, year, mileage, price);
        this.type = type;
    }
    public CarType getType(){
        return type;
    }

    @Override
    public String toString(){
        return super.toString() + " Тип: " + type;
    }
}

public class CarDealership {
    private final Set<CarWithType> cars = new HashSet<>();

    public boolean addCar(CarWithType car){
        return cars.add(car);
    }

    public List<CarWithType> findCarsByManufacturer(String manufacturer){
        return cars.stream()
                .filter(c -> c.getManufacturer().equalsIgnoreCase(manufacturer))
                .collect(Collectors.toList());
    }

    public double getAvPriceByType(CarType type){
        return cars.stream()
                .filter(c -> c.getType() == type)
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
    }

    public List<CarWithType> getCarsSortYear(){
        return cars.stream()
                .sorted(Comparator.comparingInt(Car::getYear).reversed())
                .collect(Collectors.toList());
    }

    public Map<CarType, Long> getCarTypeStat(){
        return cars.stream()
                .collect(Collectors.groupingBy(CarWithType::getType, Collectors.counting()));
    }

    public Map<String, CarWithType> getOldNewCars(){
        Map<String, CarWithType> result = new HashMap<>();
        cars.stream().max(Comparator.comparingInt(Car::getYear)).ifPresent(c-> result.put("новая", c));
        cars.stream().min(Comparator.comparingInt(Car::getYear)).ifPresent(c-> result.put("старая", c));
        return result;
    }
}
