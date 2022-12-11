package cn.acecandy.git.nasscraper.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

/**
 * @author tangningzhu
 * @since 2022/12/10
 */
@Data
@Configuration
public class NasScraperConfig {

    private final App app;

    private final Media media;
    private final Emby emby;
    private final Jellyfin jellyfin;
    private final Plex plex;
    private final ScraperNfo scraperNfo;
    private final ScraperPic scraperPic;
    private final Message message;
    private final Sync sync;
    private final Pt pt;
    private final Qbittorrent qbittorrent;
    private final DownloadDir downloadDir;
    private final Douban douban;
    private final Subtitle subtitle;
    private final Security security;
    private final Laboratory landatory;

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "app")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class App {
        private String logtype;
        private String logpath;
        private String logserver;
        private String loglevel;
        private String webHost;
        private String webPort;
        private String loginUser;
        private String loginPassword;
        private String sslCert;
        private String sslKey;
        private String rmtTmdbkey;
        private String tmdbDomain;
        private String rmtMatchMode;
        private Proxies proxies;
        private String domain;
        private String userAgent;
        private String wallpaper;
        private List<String> initFiles;

        @Data
        static class Proxies {
            private String http;
            private String https;
        }
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "media")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Media {
        private String mediaServer;
        private String mediasyncInterval;
        private List<String> moviePath;
        private List<String> tvPath;
        private List<String> animePath;
        private List<String> unknownPath;
        private String category;
        private String minFilesize;
        private String ignoredPaths;
        private Boolean filesizeCover;
        private String movieNameFormat;
        private String tvNameFormat;
        private Boolean nfoPoster;
        private Boolean refreshMediaserver;
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "emby")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Emby {
        private String host;
        private String apiKey;
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "jellyfin")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Jellyfin {
        private String host;
        private String apiKey;
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "plex")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Plex {
        private String host;
        private String token;
        private String servername;
        private String username;
        private String password;
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "scraper-nfo")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class ScraperNfo {
        private Movie movie;
        private Tv tv;

        @Data
        static class Movie {
            private Boolean basic;
            private Boolean credits;
            private Boolean creditsChinese;
        }

        @Data
        static class Tv {
            private Boolean basic;
            private Boolean credits;
            private Boolean creditsChinese;
            private Boolean seasonBasic;
            private Boolean episodeBasic;
            private Boolean episodeCredits;
        }
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "scraper-pic")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class ScraperPic {
        private Movie movie;
        private Tv tv;

        @Data
        static class Movie {
            private Boolean poster;
            private Boolean backdrop;
            private Boolean background;
            private Boolean logo;
            private Boolean disc;
            private Boolean banner;
            private Boolean thumb;
        }

        @Data
        static class Tv {
            private Boolean poster;
            private Boolean backdrop;
            private Boolean background;
            private Boolean logo;
            private Boolean clearart;
            private Boolean banner;
            private Boolean thumb;
            private Boolean seasonPoster;
            private Boolean seasonBanner;
            private Boolean seasonThumb;

        }
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "message")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Message {
        private String webhookIgnore;
        private Switch switcH;

        @Data
        static class Switch {
            private Boolean downloadStart;
            private Boolean downloadFail;
            private Boolean transferFinished;
            private Boolean transferFail;
            private Boolean rssAdded;
            private Boolean rssFinished;
            private Boolean siteSignin;
        }
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "sync")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Sync {
        private String nasSys;
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "pt")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Pt {
        private String ptClient;
        private Boolean ptMonitor;
        private Boolean ptMonitorOnly;
        private String rmtMode;
        private String searchIndexer;
        private String indexerSites;
        private Boolean searchAuto;
        private Boolean searchNoResultRss;
        private String ptsigninCron;
        private String ptSeedingTime;
        private String ptCheckInterval;
        private String searchRssInterval;
        private String downloadOrder;
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "qbittorrent")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Qbittorrent {
        private String qbhost;
        private String qbport;
        private String qbusername;
        private String qbpassword;
        private Boolean forceUpload;
        private Boolean autoManagement;
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "downloaddir")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class DownloadDir {
        private List<Ob> obs;

        @Data
        static class Ob {
            private String savePath;
            private String type;
            private String category;
            private String containerPath;
            private String label;
        }

    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "douban")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Douban {
        private List<String> users;
        private String cookie;
        private String interval;
        private String types;
        private String days;
        private Boolean autoSearch;
        private Boolean autoRss;
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "subtitle")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Subtitle {
        private String server;
        private Opensubtitles opensubtitles;
        private Chinesesubfinder chinesesubfinder;

        @Data
        static class Opensubtitles {
            private Boolean enable;
        }

        @Data
        static class Chinesesubfinder {
            private String host;
            private String apiKey;
            private String localPath;
            private String remotePath;
        }
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "security")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Security {
        private Ip mediaServerWebhookAllowIp;
        private Ip telegramWebhookAllowIp;
        private String apiKey;

        @Data
        static class Ip {
            private String ipv4;
            private String ipv6;
        }
    }

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "laboratory")
    @PropertySource(value = {"classpath:nas-scraper-config.yaml"}, factory = YamlPropertySourceFactory.class)
    public static class Laboratory {
        private Boolean searchKeyword;
        private Boolean tmdbCacheExpire;
        private Boolean useDoubanTitles;
        private Boolean searchEnTitle;
        private Boolean tmdbProxy;
    }
}