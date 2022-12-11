/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.acecandy.git.nasscraper.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.acecandy.git.nasscraper.dao.entity.MediaSyncItems;
import cn.acecandy.git.nasscraper.service.MediaSyncItemsService;
import jakarta.annotation.Resource;

/**
 * 媒体同步项目相关controller
 *
 * @author tangningzhu
 * @since 2022/12/09
 */
@RestController
@RequestMapping("/mediaSync")
public class MediaSyncItemsController {

    @Resource
    private MediaSyncItemsService mediaSyncItemsService;

    @RequestMapping(value = "/get")
    public MediaSyncItems get(Long id) {
        return mediaSyncItemsService.get(id);
    }

}