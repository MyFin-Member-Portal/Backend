package com.myfin.mapper;

import com.myfin.entity.MemberLevel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zihang Gao
 */
@Mapper
@Repository
public interface MemberLevelMapper {
    /**
     * find all info from table
     * 
     * @return list of all element of member level table
     */
    List<MemberLevel> findAll();
}
