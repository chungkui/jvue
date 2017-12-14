package org.jvue.upms.bean;

import java.util.Date;

public class Menu {
    private String id;
    private String pid;
    private String name;
    private String desc;
    private String isInUser;
    private int level;
    private String routerName;
    private Date createTime;
    private String path;
    private String FailureTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIsInUser() {
        return isInUser;
    }

    public void setIsInUser(String isInUser) {
        this.isInUser = isInUser;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFailureTime() {
        return FailureTime;
    }

    public void setFailureTime(String failureTime) {
        FailureTime = failureTime;
    }
}
