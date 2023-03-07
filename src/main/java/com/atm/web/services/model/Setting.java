package com.atm.web.services.model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ATM_SETTING", schema = "public")
public class Setting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "SETTING_ID")
    private Long id;

    @Column(name = "SETTING_KEY", unique = true)
    private String key;

    @Column(name = "SETTING_VALUE")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

}

