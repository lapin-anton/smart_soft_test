package ru.web.smart_soft_test.domain;

import javax.persistence.*;

@Entity
@Table(name="sm_top_five_forms")

@NamedQueries({
        @NamedQuery(name = "Form.findTopFiveForms",
                query = "SELECT f FROM Form f")
})

public class Form {
    @Id
    private Long id;
    @Column(name="formid")
    private String formId;
    @Column(name="url")
    private String url;
    @Column(name="orgid")
    private String orgId;
    @Column(name="count")
    private Long count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
