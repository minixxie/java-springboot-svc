package com.example.demo.support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jackson.JsonComponent;

/**
 * Define how to serialize empty object to {} in JSON.
 */
@JsonComponent
@Slf4j
public class EmptyObjectSerializer extends StdSerializer<ResponseBody.Empty> {

  public EmptyObjectSerializer() {
    this(null);
  }

  public EmptyObjectSerializer(Class<ResponseBody.Empty> t) {
    super(t);
  }

  @Override
  public void serialize(
      ResponseBody.Empty value,
      JsonGenerator generator,
      SerializerProvider provider
  ) throws IOException {

    generator.writeStartObject();
    generator.writeEndObject();
  }
}
