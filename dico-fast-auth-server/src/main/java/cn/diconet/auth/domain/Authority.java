package cn.diconet.auth.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Thomas
 * @Description: 描述
 * @date 2018\4\9 0009
 */
@Entity
@Setter
@Getter
@Table(name="sys_authority")
public class Authority {

    @Id
    private Long id;
    private String name;
    private String value;
}
