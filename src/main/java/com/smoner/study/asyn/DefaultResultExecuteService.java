package com.smoner.study.asyn;

public class DefaultResultExecuteService implements ResultExecuteService {
    @Override
    public String executeResult(ExecuteResult executeResult) {
        return "Execute Successfull ! ";
    }
}
