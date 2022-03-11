package com.song.bootproject.employees.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor //디폴트 생성자
public class HelloWorldBean {
    private String message;

    /*public String getMesasge(){
        return this.message;
    } 생성자 - lombok이 다 해줌*/
    /*public HelloWorldBean(String message){

    }(AllArgsConstructor) */
}
