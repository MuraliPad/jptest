package uk.socialmedia.commons;

import com.fasterxml.jackson.databind.JsonNode;


import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchemaValidator {

    private static final Logger log = LoggerFactory.getLogger(SchemaValidator.class);
    public ProcessingReport getValidatorReport(JsonNode jsonSchema, JsonNode jsonData) throws ProcessingException{

        final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

        final JsonSchema schema = factory.getJsonSchema(jsonSchema);


        ProcessingReport report =  schema.validate(jsonData);
        System.out.println(report);
        log.info("Schema validation report",report);

        return report;

    }
}
