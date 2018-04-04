package cn.diconet.ucenter.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.collect.Lists;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Administrator
 * @Package cn.diconet.ucenter.model
 * @Description: 描述
 * @date 2018\4\2 000216:50
 */
@Data
@Table(name = "SYS_RESOURCES")
@Entity
public class Resources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String type;
    private String url;
    private String icon;
    private Integer priority;

    @ManyToOne
    @JoinColumn(name = "pid")
    @JsonBackReference
    private Resources parent;

    @OneToMany(mappedBy="parent",orphanRemoval=true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Resources> children= Lists.newArrayList();
}