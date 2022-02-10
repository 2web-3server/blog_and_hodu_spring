package com.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PostModel {
    private Content content;
    private List<Comments> comments;
}
