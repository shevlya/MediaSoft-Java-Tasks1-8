import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\nВыберите задание:");
            System.out.println("0. Выход");
            System.out.println("1. Работа с массивами");
            System.out.println("2. Управление моделями");
            System.out.println("3. Сравнение автомобилей equals/hashCode ");
            System.out.println("4. Анализ автопарка");
            System.out.println("5. Автоцентр");
            System.out.println("Введите цифру от 0 до 5: ");
            int menuNumber;
            try {
                menuNumber = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Ошибка: укажите число от 0 до 5!");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            switch (menuNumber){
                case 0:
                    System.out.println("Выход из программы");
                    scanner.close();
                    return;

                case 1:
                    System.out.println("\n Задание 1: Массивы (Работа с парком машин)");
                    task1();
                    break;

                case 2:
                    System.out.println("\n Задание 2: Коллекции (Управление моделями)");
                    task2();
                    break;

                case 3:
                    System.out.println("\n Задание 3: equals/hashCode (Сравнение автомобилей)");
                    task3();
                    break;

                case 4:
                    System.out.println("\n Задание 4: Stream API (Анализ автопарка)");
                    task4();
                    break;

                case 5:
                    System.out.println("\n Задание 5: Практическое задание: Автоцентр (Реализация системы)");
                    task5();
                    break;

                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }


    public static void task1(){
        int[] years = Car.generateCarYear(50, 2000, 2025);
        System.out.println("Все года выпуска: " + Arrays.toString(years));

        int[] recentCars = Car.filterCarsAfterYear(years, 2015);
        System.out.println("Машины после 2015 года: " + Arrays.toString(recentCars));

        double avgAge = Car.calculAvAge(years, 2018);
        System.out.printf("Средний возраст авто: %.1f лет\n", avgAge);
    }

    public static void task2(){
        List<String> models = Arrays.asList("Toyota Camry", "BMW X5", "Tesla Model 3", "Tesla Model 3", "Tesla Model S",
                "Toyota Camry", "BMW X5","BMW X5","Infiniti QX 70");
        Set<String> uniqModelsSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        uniqModelsSet.addAll(models);
        List<String> sortList = new ArrayList<>(uniqModelsSet);
        sortList.sort(Comparator.reverseOrder());
        System.out.println("Обратная сортировка моделей: " + sortList);

        Set<String> resultSet = new LinkedHashSet<>();
        for(String model :  sortList){
            if(model.contains("Tesla")){
                resultSet.add("ELECTRO_CAR");
            }else{
                resultSet.add(model);
            }
        }
        System.out.println("Замена Tesla: " + resultSet);
    }

    public static void task3(){
        Set<Car> carSet = new HashSet<>();
        Car car1 = new Car("VIN1", "Camry", "Toyota", 2020, 25000, 15000);
        Car car2 = new Car("VIN2", "X5", "BMW", 2021, 20000, 55000);
        Car car3 = new Car("VIN1", "Rav4", "Toyota", 2018, 50000, 30000);
        Car car4 = new Car("VIN3", "Rav4", "Toyota", 2024, 60000, 90000);

        System.out.println("Добавление car1: " + carSet.add(car1));
        System.out.println("Добавление car2: " + carSet.add(car2));
        System.out.println("Добавление car3: " + carSet.add(car3));
        System.out.println("Добавление car4: " + carSet.add(car4));
        System.out.println("\nМашины в Set:");
        carSet.forEach(System.out::println);

        List<Car> sortCar = new ArrayList<>(carSet);
        Collections.sort(sortCar);
        System.out.println("Сортировка по году, от новым к старым: ");
        sortCar.forEach(System.out::println);
    }

    public static void task4(){
        List<Car> cars = Arrays.asList(new Car("VIN1", "Camry", "Toyota", 2020, 25000, 15000),
        new Car("VIN2", "X5", "BMW", 2021, 20000, 55000),
        new Car("VIN1", "Rav4", "Toyota", 2018, 50000, 30000),
        new Car("VIN3", "Rav4", "Toyota", 2024, 60000, 90000),
        new Car("VIN4", "QX70", "Infiniti", 2019, 90000, 100000)
        );

        List<Car> lowMilCars = cars.stream()
                .filter(c -> c.getMileage() < 50000)
                .collect(Collectors.toList());
        System.out.println("\nМашины с пробегом меньше 50000 км: ");
        lowMilCars.forEach(System.out::println);

        List<Car> sortPrice = cars.stream()
                .sorted(Comparator.comparingDouble(Car::getPrice).reversed())
                .collect(Collectors.toList());
        System.out.println("\nПо убыванию цены: ");
        sortPrice.forEach(System.out::println);

        List<Car> top3CarsExp = sortPrice.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("\nТоп-3 дорогие машины: ");
        top3CarsExp.forEach(System.out::println);

        double avgMile = cars.stream()
                .mapToInt(Car::getMileage)
                .average()
                .orElse(0);
        System.out.printf("\nСредний пробег: %.1f км\n", avgMile);

        Map<String, List<Car>> group = cars.stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));
        System.out.println("\nГруппы по производителям: ");
        group.forEach((manufacturer, list) -> {
            System.out.println(manufacturer + ": ");
            list.forEach(car -> System.out.println(" " + car));
        });
    }

    public static void task5(){
        CarDealership dealership = new CarDealership();
        dealership.addCar(new CarWithType("VIN1", "Camry", "Toyota", 2020, 25000, 15000, CarType.SEDAN));
        dealership.addCar(new CarWithType("VIN2", "X5", "BMW", 2021, 20000, 55000, CarType.SUV));
        dealership.addCar(new CarWithType("VIN3", "Model 3", "Tesla", 2022, 80000, 100000, CarType.ELECTRIC));
        dealership.addCar(new CarWithType("VIN4", "Rav4", "Toyota", 2024, 60000, 90000, CarType.SEDAN));

        Scanner scanner = new Scanner(System.in);
        subLoop:
        while (true) {
            System.out.println("\nВыберите задание:");
            System.out.println("0. Выход");
            System.out.println("1. Работа с массивами");
            System.out.println("2. Управление моделями");
            System.out.println("3. Сравнение автомобилей equals/hashCode ");
            System.out.println("4. Анализ автопарка");
            System.out.println("5. Автоцентр");
            System.out.println("Введите цифру от 0 до 5: ");
            int menuNumber;
            try {
                menuNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Укажите число от 0 до 5!");
                scanner.nextLine();
                continue;
            }
            switch (menuNumber) {
                case 0:
                    System.out.println("Выход из подпрограммы");
                    break subLoop;

                case 1:
                    System.out.println("Введите данные машины: ");
                    String vin = null;
                    while (true) {
                        System.out.print("VIN: ");
                        vin = scanner.nextLine().trim();
                        if (!vin.isEmpty()) {
                            break;
                        }
                        System.out.println("VIN не может быть пустым!");
                    }

                    String model = null;
                    while (true) {
                        System.out.print("Модель: ");
                        model = scanner.nextLine().trim();
                        if (model.isEmpty()) {
                            System.out.println("Модель не может быть пустой!");
                        } else if (!model.matches("[a-zA-яА-Я0-9\\-\\s]+")) {
                            System.out.println("Модель должна сожержать только буквы, цифры, пробелы или дефисы!");
                        }else{
                            break;
                        }
                    }

                    String manufacturer = null;
                    while (true) {
                        System.out.print("Производитель: ");
                        manufacturer = scanner.nextLine().trim();
                        if (manufacturer.isEmpty()) {
                            System.out.println("Производитель не может быть пустым!");
                        }else if (!manufacturer.matches("[a-zA-яА-Я]+")){
                            System.out.println("Производитель должен содержать только буквы!");
                        }else{
                            break;
                        }
                    }

                    int year = 0;
                    while (true) {
                        System.out.print("Год выпуска: ");
                        try {
                            year = Integer.parseInt(scanner.nextLine());
                            if (year >= 1900 && year <= Calendar.getInstance().get(Calendar.YEAR)) {
                                break;
                            }
                            System.out.println("Год должен быть между 1900 и текущим годом!");
                        } catch (NumberFormatException e) {
                            System.out.println("Год состоит из цифр!");
                        }
                    }

                    int mileage = 0;
                    while (true) {
                        System.out.print("Пробег (км): ");
                        try {
                            mileage = Integer.parseInt(scanner.nextLine());
                            if (mileage >= 0) {
                                break;
                            }
                            System.out.println("Пробег неотрицательный!");
                        } catch (NumberFormatException e) {
                            System.out.println("Пробег состоит из цифр!");
                        }
                    }

                    double price = 0;
                    while (true) {
                        System.out.print("Цена ($): ");
                        try {
                            price = Double.parseDouble(scanner.nextLine());
                            if (price > 0) {
                                break;
                            }
                            System.out.println("Цена не может быть отрицательной!");
                        } catch (NumberFormatException e) {
                            System.out.println("Цена состоит из цифр!");
                        }
                    }

                    CarType type = null;
                    while (true) {
                        System.out.print("Тип (SEDAN, SUV, ELECTRIC, HATCHBACK, TRUCK): ");
                        try {
                            type = CarType.valueOf(scanner.nextLine().trim().toUpperCase());
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Тип не из предложенных вариантов!");
                        }
                    }

                    boolean added = dealership.addCar(new CarWithType(vin, model, manufacturer, year, mileage, price, type));
                    System.out.println(added ? "Машина добавлена" : "Машина с таким VIN уже существует");
                    break;

                case 2:
                    scanner.nextLine();
                    while(true){
                        System.out.print("Введите производителя: ");
                        manufacturer = scanner.nextLine().trim();
                        if (manufacturer.isEmpty()) {
                            System.out.println("Производитель не может быть пустым!");
                        }else if (!manufacturer.matches("[a-zA-яА-Я]+")){
                            System.out.println("Производитель должен содержать только буквы!");
                        }else{
                            break;
                        }
                    }
                    List<CarWithType> foundCars = dealership.findCarsByManufacturer(manufacturer);
                    System.out.println("Найдено машин: " + foundCars.size());
                    foundCars.forEach(System.out::println);
                    break;

                case 3:
                    CarType carType = null;
                    while (true){
                        System.out.print("Введите тип (SEDAN, SUV, ELECTRIC, HATCHBACK, TRUCK): ");
                        String inputType = scanner.next().toUpperCase();
                        try{
                            carType = CarType.valueOf(inputType);
                            break;
                        }catch (IllegalArgumentException e){
                            System.out.println("Неверный тип! Введите снова.");
                        }
                    }
                    double avgPrice = dealership.getAvPriceByType(carType);
                    System.out.printf("Средняя цена: %.2f\n", avgPrice);
                    break;

                case 4:
                    List<CarWithType> sortedCars = dealership.getCarsSortYear();
                    System.out.println("Машины отсортированные по году: ");
                    sortedCars.forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Статистика ");
                    System.out.println("Количество по типам: ");
                    dealership.getCarTypeStat().forEach((k,v) -> System.out.println(k + ": " + v));

                    Map<String, CarWithType> oldNew = dealership.getOldNewCars();
                    System.out.println("Самая новая: " + oldNew.get("новая"));
                    System.out.println("Самая старая: " + oldNew.get("старая"));
                    break;

                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }
}