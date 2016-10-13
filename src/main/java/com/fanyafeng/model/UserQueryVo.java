package com.fanyafeng.model;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/10/12 16:52
 * Email: fanyafeng@live.cn
 */
public class UserQueryVo {

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    private UserCustom userCustom;

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
