package com.mafei.job.dao;

import com.mafei.job.pojo.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jms on 2017/10/15.
 * 登陆用户
 */
public interface AdminDAO {

    Admin getAdmin(@Param("userName") String userName, @Param("password") String password);


}
