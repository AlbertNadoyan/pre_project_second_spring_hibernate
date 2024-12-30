package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao{
    private SessionFactory sessionFactory;
    public CarDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
}
