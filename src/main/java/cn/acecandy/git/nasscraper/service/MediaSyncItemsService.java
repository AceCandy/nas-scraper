package cn.acecandy.git.nasscraper.service;

import cn.acecandy.git.nasscraper.dao.entity.MediaSyncItems;

/**
 * 媒体同步项目服务
 *
 * @author tangningzhu
 * @since 2022/12/09
 */
public interface MediaSyncItemsService {

    MediaSyncItems get(Long id);

}