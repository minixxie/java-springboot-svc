package com.example.demo.support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;

/**
 * Define how to serialize empty object to {} in JSON.
 */
@JsonComponent
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
