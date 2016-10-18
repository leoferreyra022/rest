package com.weather.rest.DAO;

import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Leo on 14/10/2016.
 */
@Repository
public interface DAI<T> {
    T getById(int id);

    List<T> getList();

    String insert(T entity);

    String delete(int id);

}
