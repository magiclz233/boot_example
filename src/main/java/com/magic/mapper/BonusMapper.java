package com.magic.mapper;

import com.magic.dto.Bonus;
import java.util.List;

public interface BonusMapper {
    int insert(Bonus record);

    List<Bonus> selectAll();
}