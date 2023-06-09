package com.example.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
public class ApiResponse<R> {
  @Getter
  public enum ProcessStatus {
    FINISHED(200),
    STOPPED_BY_CONDITION(400),
    STOPPED_BY_VALIDATION(400),
    STOPPED_BY_EXCEPTION(500),
    STOPPED_BY_ERROR(500),
    NOT_FOUND_RESOURCE(404);

    private final int statusCode;

    ProcessStatus(int statusCode) {
      this.statusCode = statusCode;
    }
  }

  private String errorMessage;
  @Builder.Default
  private ProcessStatus processStatus = ProcessStatus.FINISHED;
  private R result;

  public ApiResponse(ProcessStatus processStatus, R result){
    this.processStatus = processStatus;
    this.result = result;
  }

  public ApiResponse(ProcessStatus processStatus, String errorMessage){
    this.processStatus = processStatus;
    this.errorMessage = errorMessage;
  }
}
