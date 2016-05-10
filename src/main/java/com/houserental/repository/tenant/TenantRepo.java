package com.houserental.repository.tenant;

import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.tenant.Tenant;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by cheyikung on 4/17/16.
 */
public interface TenantRepo extends CrudRepository<Tenant, String>, TenantRepoCustom{
    @Query("{'_id' : ?0}")
    public Tenant findById(String id);

    @Query("{'facebookId' : ?0}")
    public Tenant findByFbId(String facebookId);

    @Query("{'name' : ?0}")
    public Tenant findByName(String name);

//    @Query("{'' : ?0}")
//    public List<HouseInfo> findByFirstNameLike(String value);

}
