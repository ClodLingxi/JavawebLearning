package com.lingxi.dataform;

import com.lingxi.backend.system.DataBase;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ResumeData extends DataBase {

    public static List<Resume> getResumeList(Passport passport){
        if(UserData.Validate(passport) > 0){
            String sql = "select * from resume";
            try {
                return queryRunner.query(connection, sql, new BeanListHandler<>(Resume.class));
            } catch (SQLException e) {
                logger.warning("Failed to query resume!");
                return null;
            }
        }
        return null;
    }

    public static Resume getResume(Passport passport, int id){
        if(UserData.Validate(passport) > 0){
            String sql = "select * from resume where id = ?";
            try {
                return queryRunner.query(connection, sql, new BeanListHandler<>(Resume.class), id).get(0);
            } catch (SQLException e) {
                logger.warning("Failed to query resume!");
                return null;
            }
        }
        return null;
    }

    public static Boolean Add(Resume resume) {
        String sql = "insert into resume(name,picture,gender,birthday,location,registration,phone,email,target,experience) " +
                "values(?,?,?,?,?,?,?,?,?,?)";
        try {
            int result = queryRunner.update(connection, sql, resume.toArray());
            return result > 0;
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to add user!");
            return false;
        }
    }

}
