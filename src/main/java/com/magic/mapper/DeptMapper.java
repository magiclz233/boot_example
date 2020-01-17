package com.magic.mapper;

import com.magic.dto.Dept;
import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptno);

    int insert(Dept record);

    Dept selectByPrimaryKey(Integer deptno);

    List<Dept> selectAll();

    int updateByPrimaryKey(Dept record);
}