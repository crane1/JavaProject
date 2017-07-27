package lizem.dao;

import java.math.BigDecimal;
import lizem.model.Contry;

public interface ContryMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(Contry record);

    int insertSelective(Contry record);

    Contry selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(Contry record);

    int updateByPrimaryKey(Contry record);
    
    Contry selectByPrimaryKey1(BigDecimal id);
}