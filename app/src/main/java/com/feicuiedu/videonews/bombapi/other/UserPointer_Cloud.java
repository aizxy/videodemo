package com.feicuiedu.videonews.bombapi.other;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class UserPointer_Cloud {

//    "author": { // 评论作者
//        "objectId": "D5vlAAAJ",
//                "username": "用户名"
//        "createdAt": "2016-07-11 12:20:45",
//                "updatedAt": "2016-07-11 12:20:47",
//    }

    private String objectId;
    private String username;
    private String createdAt;
    private String updatedAt;

    public UserPointer_Cloud(String objectId, String username, String createdAt, String updatedAt) {
        this.objectId = objectId;
        this.username = username;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getUsername() {
        return username;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
