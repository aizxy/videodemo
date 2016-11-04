package com.feicuiedu.videonews.bombapi.entity;

import com.feicuiedu.videonews.bombapi.other.UserPointer_Cloud;

/**
 * Created by Administrator on 2016/10/11 0011.
 */
public class CommentsEntity_Cloud extends BaseEntity {
//    {
//        "author": { // 评论作者
//                  "objectId": "D5vlAAAJ",
//                  "username": "用户名"
//                  "createdAt": "2016-07-11 12:20:45",
//                  "updatedAt": "2016-07-11 12:20:47",
//    },
//        "content": "评论内容",
//        "createdAt": "2016-07-11 12:22:03",
//        "objectId": "ioqs000W",
//        "updatedAt": "2016-07-11 12:23:10"
//        ......
//    },

    //评论内容
    private String content;
    //评论作者
    private UserPointer_Cloud author;

    public CommentsEntity_Cloud(String content, UserPointer_Cloud author) {
        this.content = content;
        this.author = author;
    }


    public String getContent() {
        return content;
    }

    public UserPointer_Cloud getAuthor() {
        return author;
    }
}
