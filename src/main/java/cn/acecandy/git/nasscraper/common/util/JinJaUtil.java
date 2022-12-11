package cn.acecandy.git.nasscraper.common.util;

import java.io.IOException;
import java.util.Map;

import com.hubspot.jinjava.Jinjava;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

/**
 * 使用jinja模板的工具类
 *
 * @author tangningzhu
 * @since 2022/12/10
 */
public class JinJaUtil {
    private static Jinjava instance = new Jinjava();

    private JinJaUtil() {
    }

    public static Jinjava getInstance() {
        return instance;
    }

    /**
     * 渲染模板
     *
     * @param response web返回
     * @param template 模板url
     * @param context  上下文
     */
    @SneakyThrows(IOException.class)
    public static void renderTemplate(HttpServletResponse response, String template, Map<String, Object> context) {
        Assert.notNull(response, "response不能为空!");
        Assert.notNull(template, "template不能为空!");
        Assert.notEmpty(context, "context不能为空!");

        String r = getInstance().render(
                ResourceUtil.readUtf8Str(StrUtil.format("templates/{}.html", template)), context);

        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Content-type", "text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(r);
    }

}