package com.aquicksoft.sync.repository;

import com.aquicksoft.sync.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepository extends MongoRepository<Image, String> {

    boolean existsByHbId(Long hbId);
}
