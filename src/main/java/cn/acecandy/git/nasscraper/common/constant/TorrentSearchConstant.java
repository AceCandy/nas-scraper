package cn.acecandy.git.nasscraper.common.constant;

import java.util.Map;

import cn.hutool.core.map.MapUtil;

/**
 * 种子搜索 常量类
 *
 * @author tangningzhu
 * @since 2022/12/10
 */
public class TorrentSearchConstant {

    /**
     * 种子搜索-格式
     */
    public static final Map<String, String> TORRENT_SEARCH_RESTYPE = MapUtil.<String, String>builder()
            .put("BLURAY", "Blu-?Ray|BD|BDRIP")
            .put("REMUX", "REMUX")
            .put("DOLBY", "DOLBY")
            .put("WEB", "WEB-?DL|WEBRIP")
            .put("HDTV", "U?HDTV")
            .put("UHD", "UHD")
            .put("HDR", "HDR")
            .put("3D", "3D").build();
    /**
     * 种子搜索-像素
     */
    public static final Map<String, String> TORRENT_SEARCH_PIX = MapUtil.<String, String>builder()
            .put("8k", "8k")
            .put("4k", "4K|2160P|X2160")
            .put("1080p", "1080[PIX]|X1080")
            .put("720p", "720P").build();
}