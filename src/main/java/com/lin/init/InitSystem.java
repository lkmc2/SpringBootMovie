package com.lin.init;

import com.lin.model.FriendlyLink;
import com.lin.model.Movie;
import com.lin.model.Website;
import com.lin.model.vo.MovieDetailVo;
import com.lin.service.FriendlyLinkService;
import com.lin.service.MovieDetailService;
import com.lin.service.MovieService;
import com.lin.service.WebsiteService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * 初始化加载数据
 * @author lkmc2
 */
@Component
public class InitSystem implements ServletContextListener, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        loadData(sce.getServletContext());
    }

    /**
     * 加载数据到application缓存中
     * @param context servlet上下文
     */
    public void loadData(ServletContext context) {
        MovieService movieService = applicationContext.getBean(MovieService.class);
        MovieDetailService movieDetailService = applicationContext.getBean(MovieDetailService.class);
        WebsiteService websiteService = applicationContext.getBean(WebsiteService.class);
        FriendlyLinkService friendlyLinkService = applicationContext.getBean(FriendlyLinkService.class);

        // 首页32条热门电影列表
        List<Movie> indexHotMovieList = movieService.getHotMovieList(1, 32);
        // 侧边栏10条热门电影列表
        List<Movie> hotMovieList = movieService.getHotMovieList(1, 10);
        // 最新电影动态列表
        List<MovieDetailVo> detailList = movieDetailService.getAllMovieDetailList(1, 10);
        // 最新网站列表
        List<Website> websiteList = websiteService.getAllWebsiteList(1, 10);
        // 最新电影列表
        List<Movie> newestMovieList = movieService.newestMovieList(1, 10);
        // 友情链接列表
        List<FriendlyLink> friendlyLinkList = friendlyLinkService.newestLinkList(1, 10);

        // 移除多余的记录
        indexHotMovieList = subList(indexHotMovieList, 32);
        hotMovieList = subList(hotMovieList, 10);
        detailList = subList(detailList, 10);
        websiteList = subList(websiteList, 10);
        newestMovieList = subList(newestMovieList, 10);
        friendlyLinkList = subList(friendlyLinkList, 10);

        context.setAttribute("newestIndexHotMovieList", indexHotMovieList);
        context.setAttribute("hotMovieList", hotMovieList);
        context.setAttribute("newestDetailList", detailList);
        context.setAttribute("newestWebSiteList", websiteList);
        context.setAttribute("newestMovieList", newestMovieList);
        context.setAttribute("friendlyLinkList", friendlyLinkList);
    }

    /**
     * 删除大于上限的记录
     * @param list 列表
     * @param count 列表条数最大值
     * @param <T> 泛型
     */
    private <T> List<T>  subList(List<T> list, int count) {
        if (list != null && list.size() > count) {
            return list.subList(0, count - 1);
        }
        return list;
    }

}
