package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);

    }

    @Override
    public List<Car> getCars() {
        TypedQuery<Car> typedQuery = sessionFactory.getCurrentSession().createQuery("from Car");
        return typedQuery.getResultList();
    }

    @Override
    public Car getCarByUser(String firstName, String lastName, String email) {
        TypedQuery<User> typedQuery = sessionFactory.getCurrentSession().createQuery
                ("from User where firstName = :firstName and lastName = :lastName and email = :email", User.class);
        typedQuery.setParameter("firstName", firstName);
        typedQuery.setParameter("lastName", lastName);
        typedQuery.setParameter("email", email);
        return typedQuery.getSingleResult().getCar();
    }
}
