package com.pearadmin.common.web.domain.response.module;

import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

import java.io.Serializable;

/**
 * Describe: 前 端 表 格 数 据 封 装
 *
 */
@Data
public class ResultTable implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 消息总量
     */
    private Long count;

    /**
     * 数据对象
     */
    private Object data;

    /**
     * 构 建
     */
    public static ResultTable pageTable(long count, Object data) {
        ResultTable resultTable = new ResultTable();
        resultTable.setData(data);
        resultTable.setCode(0);
        resultTable.setCount(count);
        return resultTable;
    }

    public static ResultTable dataTable(Object data) {
        ResultTable resultTable = new ResultTable();
        resultTable.setData(data);
        resultTable.setCode(0);
        return resultTable;
    }

}
