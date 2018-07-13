package com.wl.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 三段码
 * Created by Vincent on 2018-07-02.
 */
@Entity
@Table(name = "t_threeSectionCode")
public class ThreeSectionCode implements Serializable{

    private static final long serialVersionUID = -6142161306065137528L;

    private Integer id;

    /**
     * 三段码
     */
    private String threeCode;

    /**
     * 格口号
     */
    private String slogan;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThreeCode() {
        return threeCode;
    }

    public void setThreeCode(String threeCode) {
        this.threeCode = threeCode;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
