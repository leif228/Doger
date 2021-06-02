package com.dog.doger.app.business.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class TreeVo implements Serializable {
    private String name;
    private List<com.dog.doger.app.business.vo.TreeVo> children = new ArrayList<>();
 }
