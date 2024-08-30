package com.lingxi.dataform;

import com.lingxi.backend.system.DataBase;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ResumeData extends DataBase {

    public static List<Resume> getResumeList(Passport passport){
        if(UserData.ValidateAdmin(passport)){
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

    public static int Delete(int[] id) {
        String sql = "delete from learning.resume where id=?";
        int result = 0;
        try {
            Object[][] params = new Object[id.length][1];
            for(int i = 0; i < id.length; i++) params[i][0] = id[i];
            int[] results = queryRunner.batch(connection, sql, params);

            for (int i : results) result += i;
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to add user!");
        }
        return result;
    }

}
