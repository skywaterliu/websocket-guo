package com.mafei.job.dao;

import com.mafei.job.pojo.Device;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by jms on 2017/10/15.
 * 因为项目中要查询的表很少，就用这一个DAO层来实现
 */
@Repository
public interface MultiDAO {

    Device getDeviceById(@Param("id") String id);


}
