package com.dc.portal.config;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

import org.springframework.web.multipart.MultipartFile;

public class UploadCoercing implements Coercing<MultipartFile, String> {

	@Override
    public MultipartFile parseValue(Object input) throws CoercingParseValueException {
        if (input instanceof MultipartFile) {
            return (MultipartFile) input;
        }
        throw new CoercingParseValueException("Expected a MultipartFile object.");
    }

    @Override
    public MultipartFile parseLiteral(Object input) throws CoercingParseLiteralException {
        throw new CoercingParseLiteralException("Parsing literal not supported for MultipartFile.");
    }

//    @Override
//    public Void serialize(Object dataFetcherResult) throws CoercingSerializeException {
//        throw new CoercingSerializeException("Serialization not supported for MultipartFile.");
//    }
}

