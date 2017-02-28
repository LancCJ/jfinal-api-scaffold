package com.mlongbo.jfinal.api;

import com.jfinal.kit.JMap;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.mlongbo.jfinal.common.Require;
import com.mlongbo.jfinal.common.bean.Code;
import com.mlongbo.jfinal.common.bean.DataResponse;
import com.mlongbo.jfinal.config.AppConstant;
import com.mlongbo.jfinal.model.Beauty;
import com.mlongbo.jfinal.model.Blog;
import com.mlongbo.jfinal.model.Video;
import java.util.List;

/**
 * Created by lanccj on 2017/2/23.
 */
public class BlogAPIController extends BaseAPIController{
    private static Log log = Log.getLog(BlogAPIController.class);

    public void updateviewcount(){
        String dataType = getPara("dataType","blog");
        String id = getPara("id");

        JMap cond= JMap.create();

        //使用此方式的前提是当前controller类要继承自BaseAPIController类
        if (!notNull(Require.me().put(id, "id参数不能为空"))) {
            return;
        }

        DataResponse response=new DataResponse();
        response.setCode(Code.FAIL);
        response.setMessage("更新阅览次数失败");

        //判断检索数据类型
        switch(AppConstant.ArticalType.valueOf(dataType)){
            case video:
                break;
            case image:
                break;
            case message:
                break;
            default:
                int effectNum=Db.update(Db.getSql("updateBlogViewCount",cond),id);
                if(1==effectNum){
                    response.setCode(Code.SUCCESS);
                    response.setMessage("更新阅览次数成功");
                }
                break;
        }
        renderJson(response);
    }

    public void list(){
        Integer pageSize = getParaToInt("pageSize",6);
        Integer pageNum = getParaToInt("pageNum",1);
        String dataType = getPara("dataType","blog");
        JMap cond= JMap.create("pageStart",(pageNum-1)*pageSize).set("pageSize",pageSize);

        DataResponse response=new DataResponse();
        response.setCode(Code.FAIL);
        response.setMessage("未查询到数据");

        //判断检索数据类型
        switch(AppConstant.ArticalType.valueOf(dataType)){
            case video:
                List<Video> videos = Video.dao.find(Db.getSqlPara("listVideo",cond));
                if(videos!=null){
                    response.setCode(Code.SUCCESS);
                    response.setMessage("成功查询到视频列表数据");
                    response.setData(videos);
                }
                break;
            case image:
                List<Beauty> beauty = Beauty.dao.find(Db.getSqlPara("listImage",cond));
                if(beauty!=null){
                    response.setCode(Code.SUCCESS);
                    response.setMessage("成功查询到美图列表数据");
                    response.setData(beauty);
                }
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
