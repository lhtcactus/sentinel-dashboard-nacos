/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Zhao
 * @since 1.4.0
 */
public final class NacosConfigUtil {

    public static final String GROUP_ID = "SENTINEL_GROUP";
    
    public static final String FLOW_DATA_ID_POSTFIX = "-flow-rules";

    private NacosConfigUtil() {}

    /**
     * 将规则序列化成JSON文本，存储到Nacos server中
     *
     * @param configService nacos config service
     * @param app           应用名称
     * @param groupId       nacos groupId
     * @param postfix       规则后缀 eg.NacosPropertiesConfiguration
     * @param rules         规则对象
     * @throws NacosException 异常
     */
    public static  void publishConfig(ConfigService configService,String app,String groupId,  String postfix, List<?> rules) throws NacosException {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        configService.publishConfig(
                app+postfix,
                groupId,
                JSON.toJSONString(rules)
        );
    }

    /**
     * 从Nacos server中查询响应规则，并将其反序列化成对应Rule实体
     *
     * @param configService nacos config service
     * @param appName       应用名称
     * @param groupId       nacos groupId
     * @param postfix       规则后缀 eg.NacosPropertiesConfiguration
     * @param clazz         类
     * @param <T>           泛型
     * @return 规则对象列表
     * @throws NacosException 异常
     */
    public static <T> List<T> getRules(ConfigService configService, String appName,String groupId,  String postfix, Class<T> clazz) throws NacosException {
        String rules = configService.getConfig(
                appName+postfix,
                groupId,
                3000
        );
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        return JSON.parseArray(rules, clazz);
    }
}
