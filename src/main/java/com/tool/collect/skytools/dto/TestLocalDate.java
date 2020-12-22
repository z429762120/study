package com.tool.collect.skytools.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Testlocaldate)实体类
 *
 * @author bo
 * @since 2020-12-09 13:53:21
 */
@Data
public class TestLocalDate implements Serializable {
    private static final long serialVersionUID = -69633908023703167L;
    
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time1;

}