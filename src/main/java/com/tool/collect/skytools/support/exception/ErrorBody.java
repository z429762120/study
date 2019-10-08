package com.tool.collect.skytools.support.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangran
 * @create 2018/7/24
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorBody {
    private int code;
    private String message;
    private String throwType;
}
