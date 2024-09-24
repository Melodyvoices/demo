package com.dosoar.email_security_demo.invoker.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailClfResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String modelType;

    private List<Integer> label;

    private List<Double> proba;

    private List<String> text;

}

