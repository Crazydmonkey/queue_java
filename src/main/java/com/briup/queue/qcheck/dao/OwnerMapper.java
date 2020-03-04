package com.briup.queue.qcheck.dao;

import com.briup.queue.qcheck.bean.Owner;
import com.briup.queue.qcheck.bean.OwnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OwnerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table owner
     *
     * @mbg.generated Wed Mar 04 16:03:38 CST 2020
     */
    long countByExample(OwnerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table owner
     *
     * @mbg.generated Wed Mar 04 16:03:38 CST 2020
     */
    int deleteByExample(OwnerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table owner
     *
     * @mbg.generated Wed Mar 04 16:03:38 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table owner
     *
     * @mbg.generated Wed Mar 04 16:03:38 CST 2020
     */
    int insert(Owner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table owner
     *
     * @mbg.generated Wed Mar 04 16:03:38 CST 2020
     */
    int insertSelective(Owner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table owner
     *
     * @mbg.generated Wed Mar 04 16:03:38 CST 2020
     */
    List<Owner> selectByExample(OwnerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table owner
     *
     * @mbg.generated Wed Mar 04 16:03:38 CST 2020
     */
    Owner selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table owner
     *
     * @mbg.generated Wed Mar 04 16:03:38 CST 2020
     */
    int updateByExampleSelective(@Param("record") Owner record, @Param("example") OwnerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table owner
     *
     * @mbg.generated Wed Mar 04 16:03:38 CST 2020
     */
    int updateByExample(@Param("record") Owner record, @Param("example") OwnerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table owner
     *
     * @mbg.generated Wed Mar 04 16:03:38 CST 2020
     */
    int updateByPrimaryKeySelective(Owner record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table owner
     *
     * @mbg.generated Wed Mar 04 16:03:38 CST 2020
     */
    int updateByPrimaryKey(Owner record);
}