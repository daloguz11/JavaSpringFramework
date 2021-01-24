package com.myproject.repository;

import com.myproject.entitiy.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface KullaniciRepository extends MongoRepository<Kullanici, String> {

}
