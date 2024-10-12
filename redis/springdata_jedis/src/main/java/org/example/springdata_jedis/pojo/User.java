package org.example.springdata_jedis.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author godxiaocui
 * @date 2024/9/1811:16
 */
@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
}
