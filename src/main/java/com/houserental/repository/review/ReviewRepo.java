package com.houserental.repository.review;

import com.houserental.entity.review.Review;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by cheyikung on 4/17/16.
 */
public interface ReviewRepo extends CrudRepository<Review, String>, ReviewRepoCustom{
    @Query("{'_id' : ?0}")
    public Review findById(String id);

    @Query("{'houseId' : ?0}")
    public List<Review> findByHouseId(String id);

    @Query("{'$and':[{'houseId' : ?0}, {'landlordName':?1}]}")
    public List<Review> findByHouseIdnLid(String id, String ldname);
}
