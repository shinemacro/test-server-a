 package com.dovepay.test.server.a.bean;

import java.util.Date;

/**
 * @author zhaoyh
 * @date 2018/10/27
 */
public class B {
    private String version;
    private int id;
    private String name;
    private String description;
    private Date createTime;
    
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
    
    @Override
    public String toString() {
        return "B [version=" + version + ", id=" + id + ", name=" + name + ", description=" + description
            + ", createTime=" + createTime + "]";
    }
    
}
