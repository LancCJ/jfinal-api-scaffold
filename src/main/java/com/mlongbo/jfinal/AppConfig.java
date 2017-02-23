package com.mlongbo.jfinal;

import com.jfinal.config.*;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.mlongbo.jfinal.config.Context;
import com.mlongbo.jfinal.handler.ContextHandler;
import com.mlongbo.jfinal.interceptor.ErrorInterceptor;
import com.mlongbo.jfinal.model.*;
import com.mlongbo.jfinal.plugin.HikariCPPlugin;
import com.mlongbo.jfinal.router.APIRouter;
import com.mlongbo.jfinal.handler.APINotFoundHandler;
import com.mlongbo.jfinal.router.ActionRouter;

/**
 * JFinal总配置文件，挂接所有接口与插件
 * @author mlongbo
 */
public class AppConfig extends JFinalConfig {
    public void configEngine(Engine me) {
    }
    /**
     * 常量配置
     */
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);//开启开发模式
		me.setEncoding("UTF-8");
        me.setViewType(ViewType.JSP);
	}

    /**
     * 所有接口配置
     */
	@Override
	public void configRoute(Routes me) {
		me.add(new APIRouter());//接口路由
        me.add(new ActionRouter()); //页面路由
	}

    /**
     * 插件配置
     */
	@Override
	public void configPlugin(Plugins me) {

        //初始化连接池插件
        loadPropertyFile("jdbc.properties");
        HikariCPPlugin hcp = new HikariCPPlugin(getProperty("jdbcUrl"), 
                getProperty("user"), 
                getProperty("password"), 
                getProperty("driverClass"), 
                getPropertyToInt("maxPoolSize"));
        
        me.add(hcp);
        
        ActiveRecordPlugin arp = new ActiveRecordPlugin(hcp);
        arp.setBaseSqlTemplatePath(PathKit.getRootClassPath()+"/sqls");
        arp.addSqlTemplate("checkUser.sql");//检查用户账号是否被注册
        arp.addSqlTemplate("listBlog.sql");//查询博客列表
        arp.addSqlTemplate("listImage.sql");//查询美图列表
        arp.addSqlTemplate("listMsg.sql");//查询留言列表
        arp.addSqlTemplate("listVideo.sql");//查询视频列表
        arp.setShowSql(true);
		me.add(arp);

        // 所有配置在 MappingKit 中搞定
        _MappingKit.mapping(arp);

		//此处是手动配置  在_JFinalGenerator中配合了自动配置代码
		arp.addMapping("user", User.USER_ID, User.class);//用户表
        arp.addMapping("register_code", RegisterCode.MOBILE, RegisterCode.class); //注册验证码对象
        arp.addMapping("feedback", FeedBack.class); //意见反馈表


	}

    /**
     * 拦截器配置
     */
	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new ErrorInterceptor());
		
	}

    public static HikariCPPlugin createHikariCPPlugin() {
        return new HikariCPPlugin(PropKit.get("jdbcUrl"),
                PropKit.get("user"),
                PropKit.get("password"),
                PropKit.get("driverClass"),
                PropKit.getInt("maxPoolSize"));
    }
    /**
     * handle 配置*
     */
	@Override
	public void configHandler(Handlers me) {
        me.add(new ContextHandler());
		me.add(new APINotFoundHandler());
	}

    @Override
    public void afterJFinalStart() {
        Context.me().init();
    }

    @Override
    public void beforeJFinalStop() {
        Context.me().destroy();
    }
}