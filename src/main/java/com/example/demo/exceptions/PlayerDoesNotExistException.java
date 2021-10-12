package com.example.demo.exceptions;
import graphql.ErrorClassification;
import graphql.GraphQLError;
import java.util.List;
import graphql.ErrorType;
import graphql.language.SourceLocation;

public class PlayerDoesNotExistException extends RuntimeException implements GraphQLError {

  public PlayerDoesNotExistException (String message) {
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
