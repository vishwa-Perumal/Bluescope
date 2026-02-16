package com.TestDBs1.DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DAOInterface1Imp implements DAOInterface1 {

    @Override
    public DTOfile1 get(int id) {
        try (Connection con = DataBasetDAO.getCon();
             PreparedStatement ps =
                 con.prepareStatement("SELECT * FROM student2 WHERE id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new DTOfile1(
                        rs.getInt("id"),
                        rs.getString("sname"),
                        rs.getString("dept")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(DTOfile1 dto) {
        try (Connection con = DataBasetDAO.getCon();
             PreparedStatement ps =
                 con.prepareStatement(
                     "INSERT INTO student2(id,sname,dept) VALUES (?,?,?)")) {

            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getDept());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(DTOfile1 dto) {
        try (Connection con = DataBasetDAO.getCon();
             PreparedStatement ps =
                 con.prepareStatement(
                     "UPDATE student2 SET sname=?, dept=? WHERE id=?")) {

            ps.setString(1, dto.getName());
            ps.setString(2, dto.getDept());
            ps.setInt(3, dto.getId());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try (Connection con = DataBasetDAO.getCon();
             PreparedStatement ps =
                 con.prepareStatement("DELETE FROM student2 WHERE id=?")) {

            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}



