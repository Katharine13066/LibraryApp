package by.intexsoft.study.library.repository;

import java.util.List;

public interface Dao<T>{

    T createEntity(T t);

    T findById(Long id);

    List<T> findAll();

    T updateEntity(T t);

    void deleteAll();

    void deleteById(Long id);

}