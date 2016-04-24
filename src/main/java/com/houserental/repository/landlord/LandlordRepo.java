package com.houserental.repository.landlord;

import com.houserental.entity.landlord.Landlord;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cheyikung on 4/17/16.
 */
public interface LandlordRepo extends CrudRepository<Landlord, String>, LandlordRepoCustom {

    @Query("{'_id' : ?0}")
    public Landlord findById(String id);

    @Query("{'name' : ?0}")
    public Landlord findByName(String landlordName);

    @Query("{'phoneNum' : ?0}")
    public Landlord searchByPhoneNum(String phoneNum);

    @Query("{'email' : ?0}")
    public Iterable<Landlord> searchByEmail(String email);

}
