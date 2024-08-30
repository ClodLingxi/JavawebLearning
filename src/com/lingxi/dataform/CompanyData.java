package com.lingxi.dataform;

import com.lingxi.backend.system.DataBase;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CompanyData extends DataBase {
    public static List<Company> getCompanyList(Passport passport){
        if(UserData.ValidateAdmin(passport)){
            String sql = "select * from company";
            try {
                return queryRunner.query(connection, sql, new BeanListHandler<>(Company.class));
            } catch (SQLException e) {
                e.printStackTrace();
                logger.warning("Failed to query company list!");
                return null;
            }
        }
        return null;
    }

    public static Company getCompany(Passport passport, int id){
        if(UserData.ValidateAdmin(passport)){
            String sql = "select * from company where id = ?";
            try {
                return queryRunner.query(connection, sql, new BeanListHandler<>(Company.class), id).get(0);
            } catch (SQLException e) {
                logger.warning("Failed to query resume!");
                return null;
            }
        }
        return null;
    }

    public static Boolean addCompany(Company company) {
        String sql = "insert into company" +
                "(name,address,scale,type,introduction,state,order,picture) " +
                "values(?,?,?,?,?,?,?,?)";
        try {
            int result = queryRunner.update(connection, sql, company.toArray());
            return result > 0;
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to add user!");
            return false;
        }
    }

    public static int deleteCompany(int[] id) {
        String sql = "delete from company where id=?";
        int result = 0;
        try {
            Object[][] params = new Object[id.length][1];
            for(int i = 0; i < id.length; i++) params[i][0] = id[i];
            int[] results = queryRunner.batch(connection, sql, params);

            for (int i : results) result += i;
        } catch (SQLException e) {
            DataBase.logger.warning("Fail to delete company!");
        }
        return result;
    }
}
