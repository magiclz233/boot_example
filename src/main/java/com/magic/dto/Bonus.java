package com.magic.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Bonus implements Serializable {
    private String ename;

    private String job;

    private BigDecimal sal;

    private BigDecimal comm;

    private static final long serialVersionUID = 1L;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ename=").append(ename);
        sb.append(", job=").append(job);
        sb.append(", sal=").append(sal);
        sb.append(", comm=").append(comm);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}