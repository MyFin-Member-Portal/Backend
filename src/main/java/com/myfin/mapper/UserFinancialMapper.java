package com.myfin.mapper;

import com.myfin.entity.UserFinancial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserFinancialMapper {

    /**
     * get the user finicial information
     * @param userId
     * @return UserFinancial object
     */
    UserFinancial getUserFinancialInfo(@Param("userId") int userId);

}
