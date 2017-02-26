package net.bandung.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.bandung.bean.PostBean;
import net.bandung.dbconnection.ConnectionProvider;

public class PostDao {

    private Connection conn;

    public PostDao() {
    	conn = ConnectionProvider.getConnection();
    }

    public void addPost(PostBean postbean) {
        try {
        	String sql = "INSERT INTO post(judul, isi, kategori, author, post_date)" +
    		" VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            //ps.setInt(1, postbean.getPid());
            ps.setString(1, postbean.getJudul());
            ps.setString(2, postbean.getIsi());  
            //ps.setString(4,postbean.getGambar());    
            ps.setString(3,postbean.getKategori());  
            ps.setString(4,postbean.getAuthor());  
            ps.setString(5,postbean.getDate());     
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removePost(int postId) {
        try {
        	String sql = "DELETE FROM post WHERE postid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setInt(1, postId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      }

    public void editPost(PostBean postbean) {    	
    	try {
    		String sql = "UPDATE post SET judul=?, isi=?, gambar=?, kategori=?" +
            " WHERE postid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setString(1, postbean.getJudul());
            ps.setString(2, postbean.getIsi());  
            ps.setString(3,postbean.getGambar());    
            ps.setString(4,postbean.getKategori());              
            ps.setInt(5, postbean.getPid());
            ps.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<PostBean> getAllPosts() {
        List<PostBean> posts = new ArrayList<PostBean>();
        try {
        	String sql = "SELECT * FROM post ORDER BY postid DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PostBean postbean = new PostBean();
                postbean.setPid(rs.getInt("postid"));
                postbean.setJudul(rs.getString("judul"));
                postbean.setIsi(rs.getString("isi")); 
                postbean.setGambar(rs.getString("gambar"));    
                postbean.setKategori(rs.getString("kategori"));  
                postbean.setAuthor(rs.getString("author"));  
                postbean.setDate(rs.getString("post_date"));                            
                posts.add(postbean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }
    
    public List<PostBean> getLastPosts() {
        List<PostBean> posts = new ArrayList<PostBean>();
        try {
        	String sql = "SELECT * FROM post ORDER BY postid DESC LIMIT 3";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PostBean postbean = new PostBean();
                postbean.setPid(rs.getInt("postid"));
                postbean.setJudul(rs.getString("judul"));
                postbean.setIsi(rs.getString("isi")); 
                postbean.setGambar(rs.getString("gambar"));    
                postbean.setKategori(rs.getString("kategori"));  
                postbean.setAuthor(rs.getString("author"));  
                postbean.setDate(rs.getString("post_date"));                                
                posts.add(postbean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }

    public PostBean getPostById(int postId) {
    	PostBean postbean = new PostBean();
        try {
        	String sql = "SELECT * FROM post WHERE postid=?";
            PreparedStatement ps = conn.
                    prepareStatement(sql);
            ps.setInt(1, postId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                postbean.setPid(rs.getInt("postid"));
                postbean.setJudul(rs.getString("judul"));
                postbean.setIsi(rs.getString("isi")); 
                postbean.setGambar(rs.getString("gambar"));    
                postbean.setKategori(rs.getString("kategori"));  
                postbean.setAuthor(rs.getString("author"));  
                postbean.setDate(rs.getString("post_date"));                            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postbean;
    }
    public List<PostBean> getPostByCat(String cat) {
        List<PostBean> posts = new ArrayList<PostBean>();
        try {
        	String sql = "SELECT * FROM post where kategori='"+cat+"' ORDER BY postid DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PostBean postbean = new PostBean();
                postbean.setPid(rs.getInt("postid"));
                postbean.setJudul(rs.getString("judul"));
                postbean.setIsi(rs.getString("isi")); 
                postbean.setGambar(rs.getString("gambar"));    
                postbean.setKategori(rs.getString("kategori"));  
                postbean.setAuthor(rs.getString("author"));  
                postbean.setDate(rs.getString("post_date"));                             
                posts.add(postbean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }
}