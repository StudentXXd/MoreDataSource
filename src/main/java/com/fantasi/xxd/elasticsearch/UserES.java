package com.fantasi.xxd.elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author xxd
 * @date 2019/12/18 10:02
 */
@Document(indexName = "user", type = "docs", shards = 1, replicas = 0)
@Data
public class UserES {

    @Id
    private Long id; //主键

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String userName;

    private String phone;
}
