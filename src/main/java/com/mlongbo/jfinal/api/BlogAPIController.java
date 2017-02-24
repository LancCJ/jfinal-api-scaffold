package com.mlongbo.jfinal.api;

import com.jfinal.kit.JMap;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.mlongbo.jfinal.common.bean.Code;
import com.mlongbo.jfinal.common.bean.DataResponse;
import com.mlongbo.jfinal.config.AppConstant;
import com.mlongbo.jfinal.model.Blog;
import com.mlongbo.jfinal.model.Video;
import java.util.List;

/**
 * Created by lanccj on 2017/2/23.
 */
public class BlogAPIController extends BaseAPIController{
    private static Log log = Log.getLog(BlogAPIController.class);

    public void list(){
        Integer pageSize = getParaToInt("pageSize",6);
        Integer pageNum = getParaToInt("pageNum",1);
        String ariticalType = getPara("ariticalType","artical");
        JMap cond= JMap.create("pageStart",(pageNum-1)*pageSize).set("pageSize",pageSize);

        DataResponse response=new DataResponse();
        response.setCode(Code.FAIL);
        response.setMessage("未查询到数据");

        //判断检索数据类型
        switch(AppConstant.ArticalType.valueOf(ariticalType)){
            case video:
                List<Video> videos = Video.dao.find(Db.getSqlPara("listVideo",cond));
                if(videos!=null){
                    response.setCode(Code.SUCCESS);
                    response.setMessage("成功查询到视频列表数据");
                    response.setData(videos);
                }
                break;
            case image:
                break;
            case message:
                break;
            default:
                List<Blog> blogs = Blog.dao.find(Db.getSqlPara("listBlog",cond));
                if(blogs!=null){
                    response.setCode(Code.SUCCESS);
                    response.setMessage("成功查询到博客列表数据");
                    response.setData(blogs);
                }
                break;
        }
        renderJson(response);
    }
}
