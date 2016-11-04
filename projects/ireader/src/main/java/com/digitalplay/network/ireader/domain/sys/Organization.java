package com.digitalplay.network.ireader.domain.sys;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Formula;

import com.digitalplay.network.ireader.domain.IdEntity;
import com.digitalplay.network.ireader.util.Treeable;

/**
 * 组织机构树
 */
@Entity
@Table(name = "sys_organization")
@Cache(region="Organization",usage = CacheConcurrencyStrategy.READ_WRITE)
public class Organization extends IdEntity<Long> implements Treeable<Long>{

	private String name;

    @Enumerated(EnumType.STRING)
    private OrganizationType type = OrganizationType.branch_office;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "parent_ids")
    private String parentIds;

    private Integer weight;

    private String icon;

    @Formula(value = "(select count(*) from sys_organization f_t where f_t.parent_id = id)")
    private boolean hasChildren;

    /**
     * 是否显示
     */
    @Column(name = "is_show")
    private Boolean show = Boolean.FALSE;

    public Organization() {
    }

    public Organization(Long id) {
        setId(id);
    }

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getIcon() {
    	return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

	@Override
	public String getSeparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String makeSelfAsNewParentIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRoot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getRootDefaultIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBranchDefaultIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLeafDefaultIcon() {
		// TODO Auto-generated method stub
		return null;
	}



}
