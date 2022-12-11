package cn.acecandy.git.nasscraper.controller;

import static cn.acecandy.git.nasscraper.common.constant.CmdConstant.CMD_REFRESH_MESSAGE;
import static cn.acecandy.git.nasscraper.common.constant.CmdConstant.CMD_REFRESH_PROCESS;
import static cn.acecandy.git.nasscraper.common.constant.CmdConstant.CMD_VERSION;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.util.StrUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;

/**
 * @author tangningzhu
 * @since 2022/12/10
 */
@RestController
public class HomePageApiController {

    @RequestMapping(value = "/do")
    public String doFunc(HttpServletResponse resp, DoFuncReq req) {
        if (StrUtil.equals(CMD_VERSION, req.cmd)) {
            return """
                    {"code":0,
                    "version":"1.0.0",
                    "info":"<a href='www.baidu.com' target='_blank'>1.0.0</a>"}
                    """;
        }
        switch (req.cmd) {
            case CMD_VERSION -> {
                return """
                        {"code":0,
                        "version":"1.0.0",
                        "info":"<a href='www.baidu.com' target='_blank'>1.0.0</a>"}
                        """;
            }
            case CMD_REFRESH_MESSAGE -> {
                return """
                        {"code":0,
                        "lst_time":"",
                        "message":[]}
                        """;
            }
            case CMD_REFRESH_PROCESS -> {
                return """
                        {"code": 1, "value": 0, "text": "正在处理..."}
                        """;
            }
            default -> throw new RuntimeException("客官，你吃了空气，免费！");
        }
    }

    @Data
    static class DoFuncReq {
        private String cmd;
        private String data;

    }
}