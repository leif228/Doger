package com.dog.doger.app.business.app.service.system.impl;

import com.dog.doger.app.business.app.service.system.UserService;
import com.dog.doger.app.business.util.data.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    public UserServiceImpl() {
    }

    @Override
    public ApiResult addUser(String oid) {
        try {

            return ApiResult.success();
        } catch (Exception e) {
            return ApiResult.error(e.getMessage());
        }
    }

}
