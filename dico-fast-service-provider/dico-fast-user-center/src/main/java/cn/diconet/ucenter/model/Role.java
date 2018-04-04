package cn.diconet.ucenter.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "sys_role")
@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}
