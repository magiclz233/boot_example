package com.magic.mapper;

import com.magic.dto.Salgrade;
import java.util.List;

public interface SalgradeMapper {
    int insert(Salgrade record);

    List<Salgrade> selectAll();
}