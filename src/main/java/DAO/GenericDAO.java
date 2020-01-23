/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author ALEX FERRERAS
 * @param <T>
 */
public interface GenericDAO <T>{
    public List<T> getAll();
    
    public T getOneById(int id);
    
    public void create(T t);
    
    public void update(T t,int id);
    
    public void delete (int id);
}
