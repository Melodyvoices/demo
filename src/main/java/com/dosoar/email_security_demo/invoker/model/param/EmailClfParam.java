package com.dosoar.email_security_demo.invoker.model.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailClfParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String model_type;

    private List<String> email_path;
}
