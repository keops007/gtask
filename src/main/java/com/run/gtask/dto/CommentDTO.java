package com.run.gtask.dto;

import lombok.Data;

@Data
public class CommentDTO {

    private Long id;
    private Long taskId;
    private String content;
}
