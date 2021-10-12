package com.example.demo.exceptions;

import java.util.List;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class PlayerAlreadyExistsError extends RuntimeException implements GraphQLError {

  public PlayerAlreadyExistsError(String message) {
      super(message);
  }

  @Override
  public ErrorClassification getErrorType() {
    return ErrorType.DataFetchingException;
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public String getMessage() {
    return super.getMessage();
  }

}
