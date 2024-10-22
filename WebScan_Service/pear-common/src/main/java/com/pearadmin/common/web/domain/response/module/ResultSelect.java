package com.pearadmin.common.web.domain.response.module;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Describe: 前 端 下 拉 树
 */
@Data
public class ResultSelect implements Serializable {

    /**
     * 数据值字段名称
     */
    private String v;

    /**
     * 数据标题字段名称
     */
    private String n;

    /**
     * 子集数据字段名称
     */
    private List<ResultSelect> s;

    public ResultSelect() {}

    public ResultSelect(String v, String n) {
        this.v = v;
        this.n = n;
    }
}
