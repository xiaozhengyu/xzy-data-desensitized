# 原理说明



>   通常，如果你需要静态地定义序列化行为，可以只实现 `JsonSerializer`；如果序列化行为依赖于上下文（例如字段类型、注解或其他属性），则应实现 `ContextualSerializer`。



## JsonSerializer



`JsonSerializer` 是 Jackson 提供的一个接口，允许开发者自定义如何将一个 Java 对象序列化为 JSON。通过实现这个接口，你可以控制对象的序列化过程，例如调整字段的顺序、改变字段名称、改变输出格式等。



**主要方法：**

```java
serialize(T value, JsonGenerator gen, SerializerProvider serializers)
```

-   `T value`：待序列化的对象
-   `JsonGenerator gen`：用于写入 JSON 数据的生成器
-   `SerializerProvider serializers`：提供序列化上下文（例如，类型信息、相关序列化器等）



**示例：**

```
java复制代码public class MyCustomSerializer extends JsonSerializer<MyClass> {
    @Override
    public void serialize(MyClass value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("customName", value.getCustomName());
        gen.writeEndObject();
    }
}
```

在这个例子中，`MyCustomSerializer` 用自定义逻辑将 `MyClass` 序列化为 JSON 对象



## ContextualSerializer



`ContextualSerializer` 是 `JsonSerializer` 的一个扩展接口。它允许你在序列化的上下文中进行更动态的自定义。通过实现 `ContextualSerializer`，你可以基于对象的上下文（例如，目标字段的类型或注解）来调整序列化行为。



**主要方法：**

```java
createContextual(SerializerProvider prov, BeanProperty property)
```

-   `SerializerProvider prov`：序列化提供者，可以提供关于序列化上下文的信息
-   `BeanProperty property`：当前处理的字段或属性。你可以通过这个参数获取字段信息，如类型、注解等



**示例：**

```java
public class MyContextualSerializer extends JsonSerializer<MyClass> implements ContextualSerializer {
    private boolean someCondition;

    @Override
    public void serialize(MyClass value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (someCondition) {
            // 序列化逻辑 A
        } else {
            // 序列化逻辑 B
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        // 可以根据属性或注解决定如何序列化
        if (property != null && property.getAnnotation(MyCustomAnnotation.class) != null) {
            this.someCondition = true;
        }
        return this;
    }
}
```

在这个示例中，`MyContextualSerializer` 根据字段的注解决定使用哪种序列化策略。
