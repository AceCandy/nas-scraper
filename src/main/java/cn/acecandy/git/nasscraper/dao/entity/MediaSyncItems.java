package cn.acecandy.git.nasscraper.dao.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 影视同步数据
 *
 * @author tangningzhu
 * @date 2022/8/2
 */
@Data
@Entity
@Table(name = "tb_media_sync_items", indexes = {
        @Index(name = "MediaSyncItems_itemId", columnList = "item_id"),
        @Index(name = "MediaSyncItems_tmdbId", columnList = "tmdb_id"),
        @Index(name = "MediaSyncItems_server_library", columnList = "server, library"),
        @Index(name = "MediaSyncItems_title", columnList = "title"),
        @Index(name = "MediaSyncItems_originTitle", columnList = "origin_title"),
})
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MediaSyncItems extends BaseEntity {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 影视服务器 如jellyfin、emby、plex等 other-未知
     */
    @Column(name = "server", length = 10, nullable = false)
    @ColumnDefault("'other'")
    private String server;

    /**
     * 影视库
     */
    @Column(name = "library", length = 65, nullable = false)
    @ColumnDefault("''")
    private String library;
    /**
     * 影视 id
     */
    @Column(name = "item_id", length = 65, nullable = false)
    @ColumnDefault("''")
    private String itemId;
    /**
     * 影视类型 series-电视剧 movie-电影 other-未知
     */
    @Column(name = "item_type", length = 10, nullable = false)
    @ColumnDefault("'other'")
    private String itemType;
    /**
     * 影视标题
     */
    @Column(name = "title", length = 127, nullable = false)
    @ColumnDefault("''")
    private String title;
    /**
     * 影视原始标题
     */
    @Column(name = "origin_title", length = 127, nullable = false)
    @ColumnDefault("''")
    private String originTitle;
    /**
     * 年份
     */
    @Column(name = "production_year", length = 10, nullable = false)
    @ColumnDefault("''")
    private String productionYear;
    /**
     * tmdb中对应id
     */
    @Column(name = "tmdb_id", length = 15)
    private String tmdbId;
    /**
     * IMDB对应 id
     */
    @Column(name = "imdb_id", length = 15)
    private String imdbId;
    /**
     * 文件所在路径
     */
    @Column(name = "path", length = 1023, nullable = false)
    @ColumnDefault("''")
    private String path;

    @Column(name = "note")
    @Lob
    private String note;
    @Column(name = "json")
    @Lob
    private String json;

    @Override
    public void prePersist() {
        super.prePersist();
    }
}