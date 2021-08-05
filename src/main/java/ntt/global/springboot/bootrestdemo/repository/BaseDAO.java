package ntt.global.springboot.bootrestdemo.repository;

import ntt.global.springboot.bootrestdemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public class BaseDAO<T> implements IDAO<T>
{
    protected EntityManager entityManager;

    @Autowired
    public BaseDAO(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    public List<T> findAll()
    {
        Session session = getCurrentSession();

        Query<T> query = session.createQuery("from Employee", getGenericType());

        return query.getResultList();
    }

    @Override
    public T find(int id)
    {
        Session session = getCurrentSession();

        return session.get(getGenericType(), id);
    }

    @Override
    public void save(T t)
    {
        Session session = getCurrentSession();
        session.saveOrUpdate(t);
    }

    @Override
    public void delete(int id)
    {
        Session session = getCurrentSession();
        session.delete( session.get(getGenericType(), id));
    }

    protected Session getCurrentSession()
    {
        return entityManager.unwrap(Session.class);
    }

    private Class<T> getGenericType()
    {
        return (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
