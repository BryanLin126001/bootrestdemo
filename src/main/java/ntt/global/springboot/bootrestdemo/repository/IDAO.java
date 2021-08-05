package ntt.global.springboot.bootrestdemo.repository;

import java.util.List;

public interface IDAO<T>
{
    List<T> findAll();

    T find(int id);

    void save(T t);

    void delete(int id);

}
