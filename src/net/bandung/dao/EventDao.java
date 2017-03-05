package net.bandung.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.bandung.bean.EventBean;
import net.bandung.dbconnection.ConnectionProvider;

public class EventDao {

    private Connection conn;

    public EventDao() {
    	conn = ConnectionProvider.getConnection();
    }

    public void addEvent(EventBean Eventbean) {
        try {
        	String sql = "INSERT INTO event(eventid, nama_event, deskripsi)" +
    		" VALUES (?, ?, ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, Eventbean.getEid());
            ps.setString(2, Eventbean.getEvent());
            ps.setString(3, Eventbean.getIsi());            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeEvent(int EventId) {
        try {
        	String sql = "DELETE FROM event WHERE eventid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setInt(1, EventId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      }

    public void editEvent(EventBean Eventbean) {    	
    	try {
    		String sql = "UPDATE event SET nama_event=?, deskripsi=?" +
            " WHERE eventid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setString(1, Eventbean.getEvent());
            ps.setString(2, Eventbean.getIsi());            
            ps.setInt(3, Eventbean.getEid());
            ps.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<EventBean> getAllEvents() {
        List<EventBean> Events = new ArrayList<EventBean>();
        try {
        	String sql = "SELECT * FROM event ORDER BY eventid DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EventBean Eventbean = new EventBean();
                Eventbean.setEid(rs.getInt("eventid"));
                Eventbean.setEvent(rs.getString("nama_event"));
                Eventbean.setIsi(rs.getString("deskripsi"));   
                Eventbean.setGambar(rs.getBlob("gambar"));                                
                Events.add(Eventbean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Events;
    }
    
    public EventBean getEventById(int EventId) {
    	EventBean EventBean = new EventBean();
        try {
        	String sql = "SELECT * FROM event WHERE eventid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, EventId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	EventBean.setEid(rs.getInt("eventid"));
            	EventBean.setEvent(rs.getString("nama_event"));
            	EventBean.setIsi(rs.getString("deskripsi"));  
                EventBean.setGambar(rs.getBlob("gambar"));                                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return EventBean;
    }
}