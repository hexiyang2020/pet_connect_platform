package com.ruoyi.web.controller.hxy.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宠物信息对象 pc_pets_info
 * 
 * @author hxy
 * @date 2024-03-08
 */
public class PetsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "宠物名称", readConverterExp = "$column.readConverterExp()")
    private String petsName;

    /** $column.columnComment */
    @Excel(name = "宠物分类id", readConverterExp = "$column.readConverterExp()")
    private Long categoryId;

    private String categoryName;

    /** $column.columnComment */
    @Excel(name = "宠物年龄", readConverterExp = "$column.readConverterExp()")
    private String petsAge;

    /** $column.columnComment */
    @Excel(name = "备注", readConverterExp = "$column.readConverterExp()")
    private String reamark;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPetsName(String petsName) 
    {
        this.petsName = petsName;
    }

    public String getPetsName() 
    {
        return petsName;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setPetsAge(String petsAge)
    {
        this.petsAge = petsAge;
    }

    public String getPetsAge() 
    {
        return petsAge;
    }
    public void setReamark(String reamark) 
    {
        this.reamark = reamark;
    }

    public String getReamark() 
    {
        return reamark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("petsName", getPetsName())
            .append("categoryId", getCategoryId())
            .append("petsAge", getPetsAge())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("reamark", getReamark())
            .toString();
    }
}
