package com.ehsaniara.multidatasource.model;

import com.ehsaniara.multidatasource.utils.enums.ProxySource;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.DateUtils;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"urlWithPort", "proxySource"})
})
public class Proxy extends Auditable<String> {

    private String ipAddress;
    private Integer port;
    private String code;
    private Boolean https;
    private String urlWithPort;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastDateChecked;
    @Enumerated(EnumType.STRING)
    private ProxySource proxySource;


    public Proxy() {
    }

    public Proxy(String ipAddress, Integer port, String code, Boolean https) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.code = code;
        this.https = https;
        this.urlWithPort = ipAddress + ":" + port;
    }

    public Proxy(String ipAddress, Integer port, String code, Boolean https, Date lastDateChecked, ProxySource proxySource) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.code = code;
        this.https = https;
        this.urlWithPort = ipAddress + ":" + port;
        this.lastDateChecked = lastDateChecked;
        this.proxySource = proxySource;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getHttps() {
        return https;
    }

    public void setHttps(Boolean https) {
        this.https = https;
    }

    public String getUrlWithPort() {
        return urlWithPort;
    }

    public void setUrlWithPort(String urlWithPort) {
        this.urlWithPort = urlWithPort;
    }

    public Date getLastDateChecked() {
        return lastDateChecked;
    }

    public void setLastDateChecked(Date lastDateChecked) {
        this.lastDateChecked = lastDateChecked;
    }

    public ProxySource getProxySource() {
        return proxySource;
    }

    public void setProxySource(ProxySource proxySource) {
        this.proxySource = proxySource;
    }

    @Override
    public String toString() {
        String lastDateChecked = this.lastDateChecked == null ? "                     " : DateUtils.formatDate(this.lastDateChecked, "dd/MM/yy HH:mm:ss.SSS");

        String result;
        try {
            result = StringUtils.leftPad(String.valueOf(this.id), 10, "0") + ", "
                    + StringUtils.leftPad(this.urlWithPort == null ? "" : this.urlWithPort, 22, " ") + ", "
                    + lastDateChecked + ", "
                    + "https: " + StringUtils.leftPad(this.https == null ? "" : String.valueOf(this.https), 5, " ") + ", "
                    + StringUtils.leftPad(this.proxySource == null ? "" : this.proxySource.name(), 20, " ") + ", "
                    + this.code;

        } catch (Exception e) {
            result = "Houston, we have a problem... We cannot transform proxy to string...";
        }
        return result;
    }
}
