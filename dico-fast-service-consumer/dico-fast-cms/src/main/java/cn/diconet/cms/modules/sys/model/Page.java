package cn.diconet.cms.modules.sys.model;

import lombok.Data;

import java.util.List;

/**
 * @author
 */
@Data
public class Page {

    private int totalPages; // 总页数

    private long totalElements; // 总记录条数

    private List content; // 数据
}
