package com.hsp.navigation.pojo;

import java.io.Serializable;
import java.util.List;

public class Navigation implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer navId;

    private String title;

    private String icon;

    private Boolean spread;

    private String href;

    private String description;

    private String isUse;

    private String createTime;

    private Integer nOrder;
    
    private Integer parentId;
    
    private List<Navigation> children;
    public Integer getNavId() {
        return navId;
    }

    public void setNavId(Integer navId) {
        this.navId = navId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse == null ? null : isUse.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getnOrder() {
        return nOrder;
    }

    public void setnOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Navigation> getChildren() {
		return children;
	}

	public void setChildren(List<Navigation> children) {
		this.children = children;
	}
}