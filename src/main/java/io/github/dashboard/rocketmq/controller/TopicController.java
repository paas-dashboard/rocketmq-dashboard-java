/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.github.dashboard.rocketmq.controller;

import io.github.dashboard.rocketmq.config.RocketMqConfig;
import io.github.dashboard.rocketmq.module.CreateTopicReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.body.TopicList;
import org.apache.rocketmq.tools.admin.MQAdminExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/rocketmq")
public class TopicController {

    private final MQAdminExt mqAdmin;

    private final RocketMqConfig rocketMqConfig;

    public TopicController(@Autowired MQAdminExt mqAdmin, @Autowired RocketMqConfig rocketMqConfig) {
        this.mqAdmin = mqAdmin;
        this.rocketMqConfig = rocketMqConfig;
    }

    @PutMapping("/topics")
    public void createTopic(@RequestBody CreateTopicReq req) throws MQClientException {
        mqAdmin.createTopic(rocketMqConfig.cluster, req.getName(), 1, null);
    }

    @GetMapping("/topics")
    public TopicList listTopics() throws Exception {
        return mqAdmin.fetchAllTopicList();
    }
}
