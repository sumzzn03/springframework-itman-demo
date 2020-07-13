package com.liyong.ioccontainer.service.validator;

import javax.validation.constraints.NotNull;

public interface JobService {
    @NotNull Job findJob(@NotNull Long id);
    boolean isValide();
    Job getJob();

}
