package web.service.impl;

import org.springframework.stereotype.Service;
import web.model.Car;
import web.service.CarService;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceimpl implements CarService {
    @Override
    public List<Car> getCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("BMW", "7 Series", "Red"));
        carList.add(new Car("AUDI", "RS6", "Silver"));
        carList.add(new Car("ROLLS ROYCE", "Phantom", "White"));
        carList.add(new Car("PORSCHE", "Cayenne", "Black"));
        carList.add(new Car("MERCEDES BENZ", "S Class", "Blue"));
        return carList;
    }

    @Override
    public List<Car> getCarsByCount(int count) {
        List<Car> cars = getCars();
        if(count >= cars.size()){
            return cars;
        }else {
            return cars.subList(0, count);
        }
    }
}
