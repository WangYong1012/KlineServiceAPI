package com.brave.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("TestIndexDTO")
public class TestIndexDTO
{
    @ApiModelProperty(name = "name", value = "用户名")
    private String name;
    @ApiModelProperty(name = "age", value = "年龄")
    private int age;
    @ApiModelProperty(name = "address", value = "居住地址")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
