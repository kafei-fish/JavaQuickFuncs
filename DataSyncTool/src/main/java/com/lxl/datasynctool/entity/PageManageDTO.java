package com.lxl.datasynctool.entity;

import java.util.List;

/**
 * @author lxl
 * @date 2023年09月15日 16:53
 */
public class PageManageDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 标签图标
     */
    private String tabTitle;

    /**
     * 主键
     */
    private String tabIconPath;

    /**
     * 平台名称
     */
    private String platName;

    /**
     * 平台英文名称
     */
    private String platNameEn;

    /**
     * 登录页面图标
     */
    private String loginIconPath;

    /**
     * 登录页背景图
     * json字符串 ，数组类型，格式：[{id:"24569872365698",name:"图标名称",order:1}]
     */
    private List<LoginBgIconDTO> loginBgIconList;

    /**
     * 页面类型
     * 0：主平台页面  1：开放平台页面
     */
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTabTitle() {
        return tabTitle;
    }

    public void setTabTitle(String tabTitle) {
        this.tabTitle = tabTitle;
    }

    public String getTabIconPath() {
        return tabIconPath;
    }

    public void setTabIconPath(String tabIconPath) {
        this.tabIconPath = tabIconPath;
    }

    public String getLoginIconPath() {
        return loginIconPath;
    }

    public void setLoginIconPath(String loginIconPath) {
        this.loginIconPath = loginIconPath;
    }

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public String getPlatNameEn() {
        return platNameEn;
    }

    public void setPlatNameEn(String platNameEn) {
        this.platNameEn = platNameEn;
    }

    public List<LoginBgIconDTO> getLoginBgIconList() {
        return loginBgIconList;
    }

    public void setLoginBgIconList(List<LoginBgIconDTO> loginBgIconList) {
        this.loginBgIconList = loginBgIconList;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
