package com.xzy.data.desensitized;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Objects;

/**
 * @author xzy.xiao
 * @since 2024/12/27  9:27
 */
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class DesensitizedSerializer extends JsonSerializer<String> implements ContextualSerializer {
    private DesensitizedTypeEnum type;
    private Integer startInclude;
    private Integer endExclude;

    @Override
    public void serialize(String str, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        log.debug("数据脱敏, 脱敏类型 = {}, 原数据 = {}", type, str);
        jsonGenerator.writeString(type.desensitize(str, startInclude, endExclude));
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {

        if (beanProperty != null) {

            // 判断数据类型是否为String类型
            if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {

                // 获取定义的注解
                Desensitized desensitized = beanProperty.getAnnotation(Desensitized.class);
                if (desensitized == null) {
                    // 如果字段上没有注解，则从上下文中获取注解
                    desensitized = beanProperty.getContextAnnotation(Desensitized.class);
                }

                // 创建序列化实例
                if (desensitized != null) {
                    return new DesensitizedSerializer(desensitized.type(), desensitized.startInclude(), desensitized.endExclude());
                }
            }

            // 使用默认的序列化处理
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
        }

        // 返回默认的null值序列化处理
        return serializerProvider.findNullValueSerializer(null);
    }
}
