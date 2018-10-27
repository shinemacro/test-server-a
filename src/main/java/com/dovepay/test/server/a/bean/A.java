 package com.dovepay.test.server.a.bean;

import java.util.Date;

/**
 * @author zhaoyh
 * @date 2018/10/27
 */
public class A {
    private String version;
    private int id;
    private String name;
    private String description;
    private Date createTime;
    private String environment;
    private B b;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * @return the b
     */
    public B getB() {
        return b;
    }
    /**
     * @param b the b to set
     */
    public void setB(B b) {
        this.b = b;
    }
    /**
     * @return the environment
     */
    public String getEnvironment() {
        return environment;
    }
    /**
     * @param environment the environment to set
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }
    
    @Override
    public String toString() {
        return "A [version=" + version + ", id=" + id + ", name=" + name + ", description=" + description
            + ", createTime=" + createTime + ", environment=" + environment + ", b=" + b + "]";
    }
    
}
