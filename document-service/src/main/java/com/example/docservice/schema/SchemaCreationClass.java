package com.example.docservice.schema;

import com.example.docservice.model.entity.Company;
import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;

public class SchemaCreationClass {
    public static void main(String[] args) {
        Schema schema= ReflectData.get().getSchema(Company.class);
        System.out.println(schema.toString(true));
    }
}
