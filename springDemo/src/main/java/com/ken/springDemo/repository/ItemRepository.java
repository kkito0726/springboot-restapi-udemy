package com.ken.springDemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ken.springDemo.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
