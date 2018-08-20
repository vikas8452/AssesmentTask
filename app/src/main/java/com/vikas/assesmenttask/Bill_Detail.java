package com.vikas.assesmenttask;

/**
 * Created by sudha on 18-Aug-18.
 */

public class Bill_Detail {

    String billno, type, name, day, month, year, time, date, whereto, ofwhat;
    String status,address,jobstatus,rate,tax,discount,total,starttime,endtime,paymentstatus;

    public String getWhereto() {
        return whereto;
    }

    public void setWhereto(String whereto) {
        this.whereto = whereto;
    }

    public String getOfwhat() {
        return ofwhat;
    }

    public void setOfwhat(String ofwhat) {
        this.ofwhat = ofwhat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getJobstatus() {
        return jobstatus;
    }

    public void setJobstatus(String jobstatus) {
        this.jobstatus = jobstatus;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public Bill_Detail(String time, String date, String billno, String type, String name, String day, String month, String year, String status, String total) {
        this.date = date;
        this.billno = billno;
        this.type = type;
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.status = status;
        this.total = total;
        this.time = time;
    }

    public Bill_Detail(String billno, String type, String name, String day, String month, String year, String time, String date, String whereto, String ofwhat, String status, String address, String jobstatus, String rate, String tax, String discount, String total, String starttime, String endtime, String paymentstatus) {
        this.billno = billno;
        this.type = type;
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.time = time;
        this.date = date;
        this.whereto = whereto;
        this.ofwhat = ofwhat;
        this.status = status;
        this.address = address;
        this.jobstatus = jobstatus;
        this.rate = rate;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
        this.starttime = starttime;
        this.endtime = endtime;
        this.paymentstatus = paymentstatus;
    }

    public Bill_Detail() {
    }
}
