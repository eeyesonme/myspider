package com.digitalplay.network.ireader.sys.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.digitalplay.network.ireader.common.domain.IdEntity;

/**
 * 为了提高连表性能 使用数据冗余 而不是 组织机构(1)-----(*)职务的中间表
 * 即在该表中 用户--组织机构--职务 是唯一的  但 用户-组织机构可能重复
 */
@Entity
@Table(name = "sys_user_organization_position")
@Cache(region="UserOrganizationPosition", usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserOrganizationPosition extends IdEntity<Long> {

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "position_id")
    private Long positionId;


    public UserOrganizationPosition() {
    }

    public UserOrganizationPosition(Long id) {
        setId(id);
    }

    public UserOrganizationPosition(Long organizationId, Long jobId) {
        this.organizationId = organizationId;
        this.positionId = jobId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(long positionId) {
        this.positionId = positionId;
    }

    @Override
    public String toString() {
        return "UserOrganizationJob{id = " + this.getId() +
                ",organizationId=" + organizationId +
                ", positionId=" + positionId +
                ", userId=" + (user != null ? user.getId() : "null") +
                '}';
    }
}
