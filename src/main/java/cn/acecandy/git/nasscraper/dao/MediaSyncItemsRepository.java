package cn.acecandy.git.nasscraper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.acecandy.git.nasscraper.dao.entity.MediaSyncItems;

/**
 * 影视同步 jpa
 *
 * @author tangningzhu
 * @date 2022/8/2
 */
public interface MediaSyncItemsRepository extends JpaRepository<MediaSyncItems, Long> {
}