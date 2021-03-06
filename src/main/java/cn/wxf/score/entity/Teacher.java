package cn.wxf.score.entity;

import javax.xml.rpc.holders.ByteArrayHolder;

public class Teacher {
    String teacherId;
    String name;
    String password;
    String phone;
    String email;

    public Teacher(){}

    public Teacher(String teacherId,String name,String phone,String email){
        this.teacherId=teacherId;
        this.name=name;
        this.phone=phone;
        this.email=email;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "teacherId:"+teacherId+"\tname:"+name+"\tphone:"+phone+"\temail:"+email;
    }
}
