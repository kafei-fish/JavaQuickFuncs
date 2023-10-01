package com.lxl.webcrawler.entity;

/**
 * @author lxl
 * @date 2023年09月15日 17:16
 */
public class LoginBgIconDTO {
    private Long id;

    private String path;

    private Integer order;


    //0：没操作  1：新增  2：重新上传
    private Integer operationType;

    public LoginBgIconDTO() {
    }

    public LoginBgIconDTO(Long id, String path, Integer order, Integer operationType) {
        this.id = id;
        this.path = path;
        this.order = order;
        this.operationType = operationType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }
}
