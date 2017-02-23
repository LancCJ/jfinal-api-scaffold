package com.mlongbo.jfinal.router;

import com.jfinal.config.Routes;
import com.mlongbo.jfinal.api.*;

/**
 * @author malongbo
 */
public class APIRouter extends Routes {
    @Override
    public void config() {
        //公共api
        add("/api/v1", CommonAPIController.class);
        //用户相关
        add("/api/v1/account", AccountAPIController.class);
        //文件相关
        add("/api/v1/fs",FileAPIController.class);
    }
}
