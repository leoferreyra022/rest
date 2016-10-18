package com.weather.rest.DAO;

import java.util.List;

/**
 * Created by Leo on 14/10/2016.
 */
public interface DAI<T> {
    T getById(int id);

    List<T> getList();

    String insert(T entity);

    String delete(int id);

}
