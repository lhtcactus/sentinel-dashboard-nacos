package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lht
 * @since 2021/11/9 11:04 上午
 */
@ConfigurationProperties(prefix = "sentinel.nacos")
@Component
public class NacosPropertiesConfiguration {
    private String serverAddr;
    private String namespace = "";
    private String username = "nacos";
    private String password = "nacos";

    private String groupId = "SENTINEL_GROUP";
    private String flowDataIdPostfix ="-flow-rules";
    private  String paramFlowDataIdPostfix = "-param-rules";
    private  String authorityDataIdPostfix = "-authority-rules";
    private  String degradeDataIdPostfix = "-degrade-rules";
    private  String systemDataIdPostfix = "-system-rules";

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getFlowDataIdPostfix() {
        return flowDataIdPostfix;
    }

    public void setFlowDataIdPostfix(String flowDataIdPostfix) {
        this.flowDataIdPostfix = flowDataIdPostfix;
    }

    public String getParamFlowDataIdPostfix() {
        return paramFlowDataIdPostfix;
    }

    public void setParamFlowDataIdPostfix(String paramFlowDataIdPostfix) {
        this.paramFlowDataIdPostfix = paramFlowDataIdPostfix;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthorityDataIdPostfix() {
        return authorityDataIdPostfix;
    }

    public void setAuthorityDataIdPostfix(String authorityDataIdPostfix) {
        this.authorityDataIdPostfix = authorityDataIdPostfix;
    }

    public String getDegradeDataIdPostfix() {
        return degradeDataIdPostfix;
    }

    public void setDegradeDataIdPostfix(String degradeDataIdPostfix) {
        this.degradeDataIdPostfix = degradeDataIdPostfix;
    }

    public String getSystemDataIdPostfix() {
        return systemDataIdPostfix;
    }

    public void setSystemDataIdPostfix(String systemDataIdPostfix) {
        this.systemDataIdPostfix = systemDataIdPostfix;
    }
}
