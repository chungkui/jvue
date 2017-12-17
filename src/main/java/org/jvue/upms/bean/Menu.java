package org.jvue.upms.bean;

import java.util.Date;
import java.util.List;

public class Menu {
    private String id;
    private String pid;
    private String name;
    private String m_desc;
    private String isInUser;
    private int level;
    private String routerName;
    private Date createTime;
    private String path;
    private String FailureTime;
    private List<Menu> sunList;
    private boolean isopen;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isIsopen() {
        return isopen;
    }

    public void setIsopen(boolean isopen) {
        this.isopen = isopen;
    }

    public List<Menu> getSunList() {
        return sunList;
    }

    public void setSunList(List<Menu> sunList) {
        this.sunList = sunList;
    }

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

    public String getM_desc() {
        return m_desc;
    }

    public void setM_desc(String m_desc) {
        this.m_desc = m_desc;
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
