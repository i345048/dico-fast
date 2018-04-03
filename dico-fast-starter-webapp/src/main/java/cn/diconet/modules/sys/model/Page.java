package cn.diconet.modules.sys.model;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 * @Title: ${FILE_NAME}
 * @Package cn.diconet.modules.sys.model
 * @Description: 描述
 * @date 2018\4\3 000310:12
 */
@Data
public class Page {

   private int totalPages;

    private long totalElements;

    private List content;
}
