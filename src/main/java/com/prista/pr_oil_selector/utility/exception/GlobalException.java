package com.prista.pr_oil_selector.utility.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GlobalException extends Exception{

    private String errorMessage;
}
