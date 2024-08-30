package com.lingxi.dataform;

import com.lingxi.backend.system.DataBase;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class JobData extends DataBase {
    public static List<Job> getJobList(Passport passport){
        if(UserData.ValidateAdmin(passport)){
            String sql = "select * from job";
            try {
                return queryRunner.query(connection, sql, new BeanListHandler<>(Job.class));
            } catch (SQLException e) {
                logger.warning("Failed to query job list!");
                return null;
            }
        }
        return null;
    }

    public static int deleteJob(int[] id) {
        String sql = "delete from job where id=?";
        int result = 0;
        try {
            Object[][] params = new Object[id.length][1];
            for(int i = 0; i < id.length; i++) params[i][0] = id[i];
            int[] results = queryRunner.batch(connection, sql, params);

            for (int i : results) result += i;
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to delete job!");
        }
        return result;
    }
}
