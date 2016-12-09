package com.digitalplay.network.ireader.sys.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.digitalplay.network.ireader.common.domain.IdEntity;

/**
 * 权限表
 */
@Entity
@Table(name = "sys_permission")
@Cache(region="Permission",usage = CacheConcurrencyStrategy.READ_WRITE)
public class Permission extends IdEntity<Long>{
	
    private String name;
    private String permission;
    private String description;
    @Column(name = "is_show")
    private Boolean show = Boolean.FALSE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
