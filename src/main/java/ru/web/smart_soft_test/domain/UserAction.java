package ru.web.smart_soft_test.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="sm_user_action")

@NamedQueries({
        @NamedQuery(name = "UserAction.findAllUserActions",
                query = "SELECT ua FROM UserAction ua order by ua.ts"),
        @NamedQuery(name = "UserAction.findUserActionsOnLastHour",
                query = "SELECT ua FROM UserAction ua WHERE ua.ts BETWEEN (SELECT max(ua.ts) - 3600 from UserAction ua) " +
                        "and (SELECT max(ua.ts) from UserAction ua) order by ua.ts")
})

public class UserAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="ssoid")
    private String ssoId;
    @Column(name="ts")
    private Long ts;
    @Column(name="grp")
    private String grp;
    @Column(name="type")
    private String type;
    @Column(name="subtype")
    private String subtype;
    @Column(name="url")
    private String url;
    @Column(name="orgid")
    private String orgId;
    @Column(name="formid")
    private String formId;
    @Column(name="code")
    private String code;
    @Column(name="ltpa")
    private String ltpa;
    @Column(name="sudirresponse")
    private String sudirresponse;
    @Column(name="ymdh")
    private LocalDateTime ydmh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public void setLtpa(String ltpa) {
        this.ltpa = ltpa;
    }

    public String getSudirresponse() {
        return sudirresponse;
    }

    public void setSudirresponse(String sudirresponse) {
        this.sudirresponse = sudirresponse;
    }

    public LocalDateTime getYdmh() {
        return ydmh;
    }

    public void setYdmh(LocalDateTime ydmh) {
        this.ydmh = ydmh;
    }
}

