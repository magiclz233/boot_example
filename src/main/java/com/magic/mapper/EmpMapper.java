package com.magic.mapper;

import com.magic.dto.Emp;
import java.util.List;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    List<Emp> selectAll();

    int updateByPrimaryKey(Emp record);
}