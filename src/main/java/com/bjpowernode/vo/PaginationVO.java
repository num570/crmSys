package com.bjpowernode.vo;

import java.util.List;

public class PaginationVO<T> {

    //数据列表
    private List<T> dataList;

    //总记录数
    private Integer total;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
