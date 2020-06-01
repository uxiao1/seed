package com.test;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Description: spring-boot-api-project-seed
 * Created by hua on 2020/5/21 10:10
 *
 * @author: wwh
 */
public class TestA {

    //{
    //  "dtuid": "",
    //  "dtutype": "",
    //  "devname": "",
    //  "devtype": "",
    //  "period": "",
    //  "currentstate": "",
    //  "lastonlinetime": "2020-05-20 18:05:59",
    //  "lastofflinetime": "2020-05-20 18:05:59",
    //  "lastsynctime": "2020-05-20 18:05:59"
    //}
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            Devlist devlist = new Devlist();
            devlist.setDtuid(""+i);
            devlist.setDevname("测试设备"+i);
            devlist.setPeriod("60");
            devlist.setLastsynctime(new Date());
            devlist.setCurrentstate("0");
            HttpUtil.post("http://localhost:20854/devlist/add", JSON.toJSONString(devlist));
        }

        /*for (int i = 0; i < 1000; i++) {
            HttpRequest request = HttpUtil.createRequest(Method.DELETE, "http://localhost:20854/devlist/" + i);
            request.execute();
        }*/
    }

    static class Devlist{
        /**
         * DTU 标识
         */
        @Id
        @Column(name = "dtuId")
        @ApiModelProperty(value = "dtuId",example = "0",required = true)
        private String dtuid;

        /**
         * DTU 类型
         */
        @Column(name = "dtuType")
        @ApiModelProperty(value = "dtu类型",required = false)
        private String dtutype;

        /**
         * 电磁流量计名称
         */
        @Column(name = "devName")
        @ApiModelProperty(value = "dev名称",required = false)
        private String devname;

        /**
         * 电磁流量计类型
         */
        @Column(name = "devType")
        @ApiModelProperty(value = "dev名称",required = false)
        private String devtype;

        /**
         * 抄表周期(s)
         */
        @ApiModelProperty(value = "抄表周期(s)",required = false)
        private String period;

        /**
         * 当前状态
         */
        @Column(name = "currentState")
        @ApiModelProperty(value = "是否在线,0为不在线,1为在线",required = false)
        private String currentstate;

        /**
         * 上次上线时间
         */
        @Column(name = "lastOnlineTime")
        @ApiModelProperty(value = "上次在线时间",required = false)
        private Date lastonlinetime;

        /**
         * 上次掉线时间
         */
        @Column(name = "lastOfflineTime")
        @ApiModelProperty(value = "上次掉线时间",required = false)
        private Date lastofflinetime;

        /**
         * 最后同步时间
         */
        @Column(name = "lastSyncTime")
        @ApiModelProperty(value = "最后同步时间",required = false)
        private Date lastsynctime;

        /**
         * 获取DTU 标识
         *
         * @return dtuId - DTU 标识
         */
        public String getDtuid() {
            return dtuid;
        }

        /**
         * 设置DTU 标识
         *
         * @param dtuid DTU 标识
         */
        public void setDtuid(String dtuid) {
            this.dtuid = dtuid;
        }

        /**
         * 获取DTU 类型
         *
         * @return dtuType - DTU 类型
         */
        public String getDtutype() {
            return dtutype;
        }

        /**
         * 设置DTU 类型
         *
         * @param dtutype DTU 类型
         */
        public void setDtutype(String dtutype) {
            this.dtutype = dtutype;
        }

        /**
         * 获取电磁流量计名称
         *
         * @return devName - 电磁流量计名称
         */
        public String getDevname() {
            return devname;
        }

        /**
         * 设置电磁流量计名称
         *
         * @param devname 电磁流量计名称
         */
        public void setDevname(String devname) {
            this.devname = devname;
        }

        /**
         * 获取电磁流量计类型
         *
         * @return devType - 电磁流量计类型
         */
        public String getDevtype() {
            return devtype;
        }

        /**
         * 设置电磁流量计类型
         *
         * @param devtype 电磁流量计类型
         */
        public void setDevtype(String devtype) {
            this.devtype = devtype;
        }

        /**
         * 获取抄表周期(s)
         *
         * @return period - 抄表周期(s)
         */
        public String getPeriod() {
            return period;
        }

        /**
         * 设置抄表周期(s)
         *
         * @param period 抄表周期(s)
         */
        public void setPeriod(String period) {
            this.period = period;
        }

        /**
         * 获取当前状态
         *
         * @return currentState - 当前状态
         */
        public String getCurrentstate() {
            return currentstate;
        }

        /**
         * 设置当前状态
         *
         * @param currentstate 当前状态
         */
        public void setCurrentstate(String currentstate) {
            this.currentstate = currentstate;
        }

        /**
         * 获取上次上线时间
         *
         * @return lastOnlineTime - 上次上线时间
         */
        public Date getLastonlinetime() {
            return lastonlinetime;
        }

        /**
         * 设置上次上线时间
         *
         * @param lastonlinetime 上次上线时间
         */
        public void setLastonlinetime(Date lastonlinetime) {
            this.lastonlinetime = lastonlinetime;
        }

        /**
         * 获取上次掉线时间
         *
         * @return lastOfflineTime - 上次掉线时间
         */
        public Date getLastofflinetime() {
            return lastofflinetime;
        }

        /**
         * 设置上次掉线时间
         *
         * @param lastofflinetime 上次掉线时间
         */
        public void setLastofflinetime(Date lastofflinetime) {
            this.lastofflinetime = lastofflinetime;
        }

        /**
         * 获取最后同步时间
         *
         * @return lastSyncTime - 最后同步时间
         */
        public Date getLastsynctime() {
            return lastsynctime;
        }

        /**
         * 设置最后同步时间
         *
         * @param lastsynctime 最后同步时间
         */
        public void setLastsynctime(Date lastsynctime) {
            this.lastsynctime = lastsynctime;
        }
    }
}
