package cn.acecandy.git.nasscraper.controller;

import static cn.acecandy.git.nasscraper.common.constant.TorrentSearchConstant.TORRENT_SEARCH_PIX;
import static cn.acecandy.git.nasscraper.common.constant.TorrentSearchConstant.TORRENT_SEARCH_RESTYPE;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Maps;

import cn.acecandy.git.nasscraper.common.util.JinJaUtil;
import cn.acecandy.git.nasscraper.config.NasScraperConfig;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

/**
 * @author tangningzhu
 * @since 2022/12/10
 */
@Controller
public class HomePageController {

    @Resource
    private NasScraperConfig nasScraperConfig;

    /**
     * 主页面
     *
     * @param resp 返回值
     *
     * @return {@link String}
     */
    @SneakyThrows(Exception.class)
    @RequestMapping(value = "/")
    public void navigation(HttpServletResponse resp, HttpServletRequest req) {
        // req.getAttribute("next");
        /*# 登录认证
        if request.method == 'GET':
        GoPage = request.args.get("next") or ""
        if GoPage.startswith('/'):
        GoPage = GoPage[1:]
        if current_user.is_authenticated:
        userid = current_user.id
        username = current_user.username
        if userid is None or username is None:
        return redirect_to_login()
            else:
                # 登录成功
        return redirect_to_navigation(User().get_user(username))
        else:
        return redirect_to_login()

    else:
        GoPage = request.form.get('next') or ""
        if GoPage.startswith('/'):
        GoPage = GoPage[1:]
        username = request.form.get('username')
        password = request.form.get('password')
        remember = request.form.get('remember')
        if not username:
        return redirect_to_login('请输入用户名')
        user_info = User().get_user(username)
        if not user_info:
        return redirect_to_login('用户名或密码错误')
        # 校验密码
        if user_info.verify_password(password):
            # 创建用户 Session
        login_user(user_info)
        session.permanent = True if remember else False
            # 登录成功
        return redirect_to_navigation(user_info)
        else:
        return redirect_to_login('用户名或密码错误')*/

        Map<String, Object> context = Maps.newHashMap();
        context.put("SystemFlag", 1);
        context.put("SyncMod", StrUtil.isNotEmpty(nasScraperConfig.getPt().getRmtMode()) ?
                nasScraperConfig.getPt().getRmtMode() : "link");
        context.put("TMDBFlag", nasScraperConfig.getApp().getRmtTmdbkey());
        context.put("RestypeDict", TORRENT_SEARCH_RESTYPE);
        context.put("PixDict", TORRENT_SEARCH_PIX);
        // 写死
        context.put("AppVersion", "1.0.0");
        context.put("GoPage", "index");
        context.put("UserName", nasScraperConfig.getApp().getLoginUser());
        context.put("UserPris", "我的媒体库,资源搜索,推荐,站点管理,订阅管理,下载管理,媒体整理,服务,系统设置");

        JinJaUtil.renderTemplate(resp, "navigation", context);
    }

    /**
     * 开始页面
     *
     * @param resp 返回值
     */
    @RequestMapping(value = "/index")
    public void index(HttpServletResponse resp) {
        Map<String, Integer> mediaCount = MapUtil.<String, Integer>builder()
                .put("MovieCount", 100).put("SeriesCount", 101)
                .put("SongCount", 99).put("EpisodeCount", 909)
                .build();

        Map<String, Object> context = MapUtil.<String, Object>builder()
                .put("MediaCount", mediaCount)
                .put("ServerSucess", true).put("Activitys", null).put("UserCount", 3)
                .put("FreeSpace", "1.3").put("TotalSpace", "3")
                .put("UsedSapce", "1.7").put("UsedPercent", 55)
                .put("MovieChartLabels", null).put("TvChartLabels", null)
                .put("MovieNums", 3).put("TvNums", 4).put("AnimeNums", 5)
                .put("MediaServerType", "Jellyfin")
                .build();

        JinJaUtil.renderTemplate(resp, "index", context);
    }

}