package cn.acecandy.git.nasscraper.service.impl;

import org.springframework.stereotype.Service;

import cn.acecandy.git.nasscraper.dao.entity.MediaSyncItems;
import cn.acecandy.git.nasscraper.dao.MediaSyncItemsRepository;
import cn.acecandy.git.nasscraper.service.MediaSyncItemsService;
import jakarta.annotation.Resource;

/**
 * 媒体同步项目 服务实现
 *
 * @author tangningzhu
 * @since 2022/12/09
 */
@Service
public class MediaSyncItemsServiceImpl implements MediaSyncItemsService {

    @Resource
    private MediaSyncItemsRepository mediaSyncItemsRepository;

    @Override
    public MediaSyncItems get(Long id) {
        return mediaSyncItemsRepository.findById(id).orElse(null);
    }

}