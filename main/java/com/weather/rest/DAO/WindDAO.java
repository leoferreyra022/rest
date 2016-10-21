package com.weather.rest.DAO;

import com.weather.rest.Config.singletonConnection;
import com.weather.rest.Domain.Location;
import com.weather.rest.Domain.Wind;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Leo on 18/10/2016.
 */
public class WindDAO implements DAI<Wind>
{
    @Autowired
    singletonConnection conn;
    @Autowired
    Location location;
    private Connection connection = conn.getInstance().getConnection();

    private static final String INSERT = "INSERT INTO wind (velocity,direction) values(?,?) ";
    private static final String DELETE = "DELETE FROM wind WHERE id_wind = ";
    private static final String FIND_BY_ID = "SELECT * FROM wind WHERE id_wind = ";
    private static final String FIND_ALL = "SELECT * FROM wind";

    @Override
    public Wind getById(int id)
    {
        Statement stmt = null;
        ResultSet rs = null;
        try
        {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(FIND_BY_ID + id);
            while(rs.next())
            {
                return getWind(rs);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Wind> getList()
    {
        List<Wind> windList = new LinkedList<>();
        try (PreparedStatement stmt = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Wind wind = getWind(rs);
                windList.add(wind);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return windList;
    }

    @Override
    public String insert(Wind entity)
    {
        String msg = "Wind insertion succesfull";
        PreparedStatement stmnt = null;
        int result = 0;
        try {
            stmnt = connection.prepareStatement(INSERT);
            stmnt.setInt(1,entity.getVelocity());
            stmnt.setString(2,entity.getDirection());
            result = stmnt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        if(result==0)msg = "Fallo al insertar";
        return msg;
    }

    @Override
    public String delete(int id)
    {
        String msg = "Delete succesfull";
        PreparedStatement statement = null;
        int result=0;
        try {
            statement = connection.prepareStatement(DELETE + id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(result==0)msg = "Fallo al borrar";
        }
        return msg;
    }

    public static Wind getWind(ResultSet resultSet) throws SQLException
    {
        Wind.WindBuilder windBuilder = Wind.WindBuilder.aWind()
                .withDirection(resultSet.getString("direction"))
                .withVelocity(resultSet.getInt("velocity"));
        return windBuilder.createWind();
    }
}
