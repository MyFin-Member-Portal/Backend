package com.myfin.mapper;

import com.myfin.entity.UserFamily;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserFamilyMapper {
    /**
     * get the user family info by user id
     * @param userId the user id
     * @return an entity of userFamily entity
     */
    UserFamily getUserFamilyInfo(@Param("userId") int userId);

    void updateUserFamilyInfo(
            @Param("userId") int userId,
            @Param("martialStatus") String martialStatus,
            @Param("depNum") String depNum,
            @Param("petsNum") String petsNum,
            @Param("supNonDepNum") String supNonDepNum,
            @Param("expectMedBill") String expectMedBill
    );

    int createUserFamilyInfo(@Param("userId") int userId);
}
