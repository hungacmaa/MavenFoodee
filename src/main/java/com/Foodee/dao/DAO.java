/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.dao;

import java.util.List;

/**
 *
 * @author Admin
 * @param <T>
 */
public interface DAO<T> {
    List<T> getAll();
 
    List<T> getById();
    
    T get(int id);
 
    void save(T t);
 
    void update(T t);
 
    void delete(T t);
}
