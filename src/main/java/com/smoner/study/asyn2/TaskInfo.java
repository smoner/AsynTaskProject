package com.smoner.study.asyn2;

import java.util.List;

public class TaskInfo {
    private  String subOrgId ;
    private  List<String> vendorIds;
    private  ExecuteResult executeResult;

    public TaskInfo(){}
    public TaskInfo(String subOrgId,List<String> vendorIds,ExecuteResult executeResult){
        this.subOrgId =subOrgId;
        this.vendorIds = vendorIds;
        this.executeResult =executeResult;
    }
    public String getSubOrgId() {
        return subOrgId;
    }

    public void setSubOrgId(String subOrgId) {
        this.subOrgId = subOrgId;
    }

    public List<String> getVendorIds() {
        return vendorIds;
    }

    public void setVendorIds(List<String> vendorIds) {
        this.vendorIds = vendorIds;
    }

    public ExecuteResult getExecuteResult() {
        return executeResult;
    }

    public void setExecuteResult(ExecuteResult executeResult) {
        this.executeResult = executeResult;
    }
}
