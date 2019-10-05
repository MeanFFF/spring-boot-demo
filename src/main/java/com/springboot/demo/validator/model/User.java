package com.springboot.demo.validator.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * description
 *
 * @author gangping.liu <gangping.liu@ucarinc.com>
 * @version V1.0.0
 * @date 2019-10-05 09:47:36
 * @since 1.0
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -2731598327208972274L;
    @NotNull(message = "{required}")
    private String username;

    @NotNull(message = "{required}")
    @Email(message = "{invalid}")
    @Length(max = 11, message = "长度不能超过11")
    private String email;

    @NotNull(message = "{required}")
    @Range(min = 1L, max = 120L, message = "年龄应为0-120")
    private Integer age;

    @NotNull(message = "{required}")
    @DecimalMin(value = "-1.00", message = "工资不能小于-1.00")
    @DecimalMax(value = "999999999999.00", message = "工资不能超过999999999999.00")
    /** @Range(min = 1L, max = 123123L, message = "年龄应为0-120") */
    private BigDecimal balance;

    @NotNull
    private Double price;
}
