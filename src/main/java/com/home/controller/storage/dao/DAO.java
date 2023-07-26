package com.home.controller.storage.dao;

import com.home.model.Entity;

public interface DAO <E extends Entity<K>, K>{

    E create(E e);
    E delete(E e);
    E update(E e);
    E find(K k);


}
