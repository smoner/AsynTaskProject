package com.smoner.study.asyn;

public class TaskInfo implements Task {

    String key ;
    public TaskInfo(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
